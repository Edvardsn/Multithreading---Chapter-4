package src;

import java.net.ServerSocket;

/**
 * Parent class for single- and multi-threaded servers.
 */
public class Server {

    protected static final int port = 8080;
    protected ServerSocket welcomingSocket;

    /**
     * Create server object
     */
    public Server() {
        try {
            this.welcomingSocket = new ServerSocket(port);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
