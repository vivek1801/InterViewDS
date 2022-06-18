package threads;

public class ThreadBasicL1 {
  public static void main(String[] args) throws InterruptedException {
    Thread thread=new Thread(new Runnable() {
      @Override
      public void run() {
        System.out.println(" We are now in thread " + Thread.currentThread().getName());
      }
    });
    thread.setName("New Worker thread");
    thread.setPriority(Thread.MAX_PRIORITY);
    System.out.println(" We are in thread: "+ Thread.currentThread().getName()+" Before starting a new Thread");
    thread.start();
    System.out.println("We are in therad: "+ Thread.currentThread().getName()+" After starting the thread");
    Thread.sleep(10000);
  }
}
