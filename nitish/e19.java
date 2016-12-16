public class e19{
  public static void main(String[] args) throws Exception{
    Runnable r = new Runnable(){
      public void run(){
        try{
          Thread.sleep(2000);
        }catch(InterruptedException ie){
          System.out.println("interupted");
        }
        System.out.println("ran");
      }
    };

    Thread t = new Thread(r);
    t.start();
    System.out.println("started");
    t.sleep(2000);
    System.out.println("interrupting");
    t.interrupt();
    System.out.println("ended");
  }
}
