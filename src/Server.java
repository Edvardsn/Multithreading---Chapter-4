package src;

import java.net.ServerSocket;


public class Server {

    protected static final int port = 8080;
    protected static int portCounter = 0;
    protected ServerSocket welcomingSocket;

    public Server(){

        try{
            ServerSocket newSocket = new ServerSocket(port);

            this.welcomingSocket = newSocket;
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }





}
