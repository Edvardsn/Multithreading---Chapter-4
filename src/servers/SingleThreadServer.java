package src.servers;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import src.computation.SearchSimulator;

/**
 * A single threaded server to handle client requests
 * 
 */
public class SingleThreadServer extends Server implements Runnable {

    boolean isStopped = false;
    Socket incomingSocket; // declare variable

    /**
     * Creates a single threaded server
     */
    public SingleThreadServer() {
        super();
    }

    @Override
    public void run() {

        System.out.println("Listening on port: " + port);

        while (!isStopped()) {

            try {

                incomingSocket = welcomingSocket.accept(); // listen for request

                System.out.println("Request incoming, creating new connection socket at port : "
                        + String.valueOf(incomingSocket.getPort() + "\n"));

                handleClientRequest(incomingSocket);

            } catch (Exception e) {
                stop();
                e.printStackTrace();
            }
        }
    }

    /**
     * Creates a new socket to handle the request.
     * 
     * @param socket The socket originally used to communicate
     */
    public void handleClientRequest(Socket incomingSocket) throws Exception {
        System.out.println(incomingSocket.getInetAddress() + ":" + incomingSocket.getPort());
        SearchSimulator.clientRequest(incomingSocket, "Single threaded server: ");
    }

    private synchronized boolean isStopped() {
        return this.isStopped = false;
    }

    /**
     * Closes serversocket and stops server.
     */
    private synchronized void stop() {
        System.out.println("Server stopped.");
        this.isStopped = true;
        try {
            welcomingSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}