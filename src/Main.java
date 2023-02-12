package src;

import src.servers.MultiThreadServer;
import src.servers.SingleThreadServer;

public class Main {
    public static void main(String[] args) {
        Thread mainThread = new Thread(new MultiThreadServer());
        mainThread.setName("Main thread");
        mainThread.run();
    }
}