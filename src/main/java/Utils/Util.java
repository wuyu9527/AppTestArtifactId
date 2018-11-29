package Utils;

public class Util {

    private volatile static Util util;

    public synchronized static Util instance() {
        if (util == null) {
            util = new Util();
        }
        return util;
    }

    public Util() {
    }

    /**
     * @param seconds 秒
     */
    public synchronized void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
