package src;

public class Main {
    
    public static void main(String[] args) {
       Thread mainThread = new Thread(new SingleThreadServer());
       mainThread.setName("Main thread");
       mainThread.start();
    }
}
