package src;

import java.io.InputStream;
import java.net.Socket;
import java.lang.Thread;

/**
 * A single threaded server to handle client requests
 * 
 */
public class MultiThreadServer extends Server implements Runnable {


    /**
     * Creates a single threaded server
     * 
     */
    public MultiThreadServer(){
        super();
    }


    public void handleClientRequest(Socket socket){

        Thread thread = new ;

    }

    @Override
    public void run() {
        while(true){
            try(Socket incomingSocket = welcomingSocket.accept();){

                handleClientRequest(incomingSocket);
                
            } catch (Exception e) {
                System.out.println("gucci");
            }

        }

        
    }
}







