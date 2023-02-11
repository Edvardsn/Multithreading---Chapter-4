package src;


/**
 * Send a fake computational request to server.
 */
public class SearchSimulator {


    private static int counter = 0;

    public static String clientRequest() throws InterruptedException {
        counter++;

        System.out.println("Incoming Request ID: nr." + counter);

        long time1 = System.currentTimeMillis();
        System.out.println("Request processing started at: " + (time1 / 1000) + "milliseconds.");

        Thread.sleep(100); // 10 seconds, 10000

        long time2 = System.currentTimeMillis();
        System.out.println("Request processing ended at: " + (time2 / 1000) + "milliseconds.");

        String responseBody = ResponseGenerator.generatorResponseHTML(time1, time2, counter);
        String responseHeader = ResponseGenerator.generatorResponseHeader(responseBody.length());

        String message = responseHeader + responseBody; 

        return message;
    }

}