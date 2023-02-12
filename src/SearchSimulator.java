package src;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Send a fake computational request to server.
 */
public class SearchSimulator {

    private static int counter = 0;

    public static void clientRequest(Socket socket, String title) throws InterruptedException, IOException {
        counter++;

        System.out.println("Incoming Request ID: nr." + counter);

        long time1 = System.currentTimeMillis();
        System.out.println("Request processing started at: " + (time1) + " milliseconds.");

        Thread.sleep(10000); // 10 seconds, 10000

        long time2 = System.currentTimeMillis();
        System.out.println("Request processing ended at: " + (time2 - time1) + " milliseconds."); // time taken

        String responseBody = ResponseGenerator.generatorResponseHTML(time1, time2, counter);
        String responseHeader = ResponseGenerator.generatorResponseHeader(responseBody.length());

        String message = responseHeader + responseBody;

        new PrintWriter(socket.getOutputStream(), true).println(message);
    }
}