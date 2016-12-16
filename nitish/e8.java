public class e8 implements Runnable{
   public void run(){
    System.out.println("run.");
    throw new RuntimeException("Problem");
   }

   public static void main(String gg[]) throws InterruptedException{
    Thread t = new Thread(new e8());
    t.start();
    System.out.println("End of method");
   }
}
