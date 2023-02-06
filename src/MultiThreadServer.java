package src;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;


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

    /**
     * Creates a new socket to handle the request.
     * 
     * @param socket The socket originally used to communicate
     */
    public void handleClientRequest(Socket incomingSocket){
        try(Socket newSocket = new Socket("localhost",this.port + this.portCounter);){
            this.portCounter++;

            // BufferedWriter: To save incoming data when sending is slower than reciving.
            // PrintWrter: To be able to control when the data is sent. In bufferedwriter all data is sent once recieved.
            // OutputstreamWriter: Converts charaters to bytes to be able to be sent as a stream
            PrintWriter output = new PrintWriter(new BufferedWriter(new OutputStreamWriter(newSocket.getOutputStream())));

            // Same shit here
            BufferedReader input = new BufferedReader(new InputStreamReader(newSocket.getInputStream()));

            output.write(SearchSimulator.clientRequest());
        }

        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while(true){
            System.out.println("Searching");
            
            try(Socket incomingSocket = welcomingSocket.accept();){

                handleClientRequest(incomingSocket);
                
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        
    }
}







