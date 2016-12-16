public class e10{
  static class A{
    void process() throws Exception{
      System.out.println("A");
    }
  }
  static class B extends A{
    void process() throws RuntimeException{
      System.out.println("B");
    }
  }
}
