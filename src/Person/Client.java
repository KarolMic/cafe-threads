package Person;

import Room.CashDesk;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Application client class.
 *
 * @author Karol Mickiewicz
 */
public class Client implements Runnable {

    private CashDesk cashDesk;
    private String name;
    public static final Logger log = Logger.getLogger(Cashier.class.getName());

    public Client(CashDesk cashDesk, String name) {
        this.cashDesk = cashDesk;
        this.name = name;
    }

    /**
     * Application method responsible for drinking cafe products by clients.
     *
     */
    @Override
    public void run() {

        while (!Thread.currentThread().isInterrupted()) {

            try {
                String cafeProduct = cashDesk.take();
                System.out.println(name + " is drinking " + cafeProduct);
                Thread.sleep(cafeProduct.length() * 1000);
            } catch (InterruptedException ex) {
                log.log(Level.WARNING, "Thread Client " + name + " interrupted!");
                break;
            }

        }

    }

}
