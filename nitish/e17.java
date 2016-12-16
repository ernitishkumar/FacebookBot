public class e17{
  String title;
  int value;
  public e17(){
    title += " World";
  }

  public e17(int value){
    this.value = value;
    title = "Hello";
  }

  public static void main(String[] args) {
    e17 e = new e17();
    System.out.println(Thread.currentThread().getId()+" "+Thread.currentThread().getName());
  }
}
