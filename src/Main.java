package src;

public class Main {
    
    public static void main(String[] args) {
       Thread mainThread = new Thread(new MultiThreadServer());
       mainThread.setName("Main thread");
       mainThread.start();
    }
}
