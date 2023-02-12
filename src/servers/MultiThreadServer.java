package src.servers;

import java.io.IOException;
import java.net.Socket;

import src.computation.AsyncSearchSimulator;

public class MultiThreadServer extends Server implements Runnable {

    boolean isStopped = false;
    Socket incomingSocket; // declare variable

    public MultiThreadServer() {
        super();
    }

    @Override
    public void run() {

        System.out.println("Multi-threaded server listening on port: " + port);

        while (!isStopped()) {
            try {
                incomingSocket = welcomingSocket.accept();

                System.out.println("Request incoming, creating new connection socket at port : "
                        + String.valueOf(incomingSocket.getPort() + "\n"));

                new Thread(new AsyncSearchSimulator(incomingSocket, "Multithread")).start();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private synchronized boolean isStopped() {
        return this.isStopped = false;
    }
}