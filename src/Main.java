import Person.Cashier;
import Person.Client;
import Room.CashDesk;

import java.util.Scanner;

/**
 * Application main class.
 *
 * @author Karol Mickiewicz
 */
public class Main {

    /**
     * Application main method.
     *
     * @param args application command line arguments
     */
    public static void main(String[] args) {

        CashDesk cashDesk = new CashDesk();

        Cashier cashier = new Cashier(cashDesk);

        Thread barmanThread = new Thread(cashier);

        barmanThread.start();

        Client[] clients = {
                new Client(cashDesk, "Gregor"),
                new Client(cashDesk, "Christian"),
                new Client(cashDesk, "Jennifer"),
                new Client(cashDesk, "Mary"),
                new Client(cashDesk, "Patricia")
        };

        Thread[] threads = {
                new Thread(clients[0]),
                new Thread(clients[1]),
                new Thread(clients[2]),
                new Thread(clients[3]),
                new Thread(clients[4])
        };

        for (Thread thread : threads) {
            thread.start();
        }

        /**
        * If you want to stop program press enter.
         */
        Scanner scanner = new Scanner(System.in);

        if (scanner.nextLine().equals("")) {
            for (Thread thread : threads) {
                thread.interrupt();
            }
            barmanThread.interrupt();
            Thread.currentThread().interrupt();
            System.out.println("Program terminated.");
        }

    }

}
