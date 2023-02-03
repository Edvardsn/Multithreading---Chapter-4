package computation;

/**
 * Send a fake computational request to server.
 */
public class searchSimulator {

    public static void clientRequest() throws InterruptedException {

        long time1 = System.currentTimeMillis();
        System.out.println("Request processing started at: " + time1 + "milliseconds.");

        Thread.sleep(10 * 100); // 10 seconds, 10000

        long time2 = System.currentTimeMillis();
        System.out.println("Request processing ended at: " + time2 + "milliseconds.");

        long result = time2 - time1;
        System.out.println("" + result + "milliseconds, equal to: " + (result / 1000) + "seconds");

    }

    public static void main(String[] args) throws InterruptedException {
        clientRequest();
    }
}