package src;

import java.net.ServerSocket;


public class Server {

    private static final int port = 8080;
    protected ServerSocket welcomingSocket;

    public Server(){

        try(ServerSocket newSocket = new ServerSocket(port);){

            this.welcomingSocket = newSocket;

        }
        catch (Exception e) {
            System.out.println("oups");
        }

    }

    



}
