package Room;
import java.util.ArrayList;

/**
 * Application CashDesk class.
 *
 * @author Karol Mickiewicz
 */
public class CashDesk {

    private ArrayList<String> list = new ArrayList<>();
    private String value = null;

    /**
     * Application method responsible for taking cafe products by clients from the cash desk.
     *
     */
    public synchronized String take() throws InterruptedException {

        while (value == null) {
            if (!list.isEmpty()) {
                value = list.remove(0);
            } else {
                wait(); //Wait, maybe someone will put sth here.
            }
        }
        String ret = value;
        value = null;
        return ret;
    }

    /**
     * Application method responsible for putting multiply cafe products on the cash desk.
     *
     */
    public synchronized void put(String value) {
        list.add(value);
        notifyAll();
    }

}
