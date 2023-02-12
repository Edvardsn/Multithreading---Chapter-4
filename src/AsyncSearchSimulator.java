package src;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class AsyncSearchSimulator implements Runnable {

    private Socket incomingSocket;
    private String serverText;
    private static int counter;

    public AsyncSearchSimulator(Socket incomingSocket, String serverText) {
        this.incomingSocket = incomingSocket;
        this.serverText = serverText;
    }

    @Override
    public void run() {

        try {
            counter++;

            System.out.println("Incoming Request ID: nr." + counter);

            long time1 = System.currentTimeMillis();
            System.out.println("Request processing started at: " + (time1 / 10000) + "milliseconds.");

            Thread.sleep(10000); // 10 seconds, 10000

            long time2 = System.currentTimeMillis();
            System.out.println("Request processing ended at: " + (time2 / 10000) + "milliseconds.");

            String responseBody = ResponseGenerator.generatorResponseHTML(time1, time2, counter);
            String responseHeader = ResponseGenerator.generatorResponseHeader(responseBody.length());

            String message = responseHeader + responseBody;

            new PrintWriter(incomingSocket.getOutputStream(), true).println(message);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
