package Person;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import Room.CashDesk;

/**
 * Application Cashier class.
 *
 * @author Karol Mickiewicz
 */
public class Cashier implements Runnable {

    private CashDesk cashDesk;

    private String[] menu = {"Espresso", "Ristretto", "Espresso doppio", "Cappuccino",
            "Macchiato", "Lungo", "Latte macchiato", "Caffe latte", "Mocha", "Romano", "Freddo",
            "Café frappe", "Tea", "Hot Chocolate"};

    public static final Logger log = Logger.getLogger(Cashier.class.getName());

    public Cashier(CashDesk cashDesk) {
        this.cashDesk = cashDesk;
    }

    Random random = new Random();

    /**
     * Application method responsible for passing cafe products to cash desk.
     *
     */
    @Override
    public void run() {

        while (!Thread.currentThread().isInterrupted()) {

            try {
                cashDesk.put(menu[random.nextInt(menu.length)]);
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                log.log(Level.WARNING, "Thread Cashier interrupted!");
                break;
            }

        }

    }

}
