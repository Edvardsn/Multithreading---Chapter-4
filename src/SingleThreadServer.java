package src;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;


/**
 * A single threaded server to handle client requests
 * 
 */
public class SingleThreadServer extends Server implements Runnable {


    /**
     * Creates a single threaded server
     * 
     */
    public SingleThreadServer(){
        super();
    }

    /**
     * Creates a new socket to handle the request.
     * 
     * @param socket The socket originally used to communicate
     */
    public void handleClientRequest(Socket incomingSocket) throws Exception{
    
        SearchSimulator simulator = new SearchSimulator();

        // BufferedWriter: To save incoming data when sending is slower than reciving.
        // PrintWrter: To be able to control when the data is sent. In bufferedwriter all data is sent once recieved.
        // OutputstreamWriter: Converts charaters to bytes to be able to be sent as a stream
        PrintWriter output = new PrintWriter(new BufferedWriter(new OutputStreamWriter(incomingSocket.getOutputStream())),true);

        output.write(simulator.clientRequest());

        System.out.println("Message sent \n");
    }

    @Override
    public void run() {

        while(true){
          
           System.out.println("Searching on port: " + this.port);
            
            try(Socket incomingSocket = welcomingSocket.accept();){

                System.out.println("Request incoming, creating new connection socket at port : " 
                + String.valueOf(incomingSocket.getPort() + "\n"));

                handleClientRequest(incomingSocket);
                
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        
    }
}







