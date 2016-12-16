interface declare{
  public static final int EASY = 3;
  void doStuff(int t);
}

public class e12 implements declare{
  public static void main(String[] args) {
    int x = 5;
    new e12().doStuff(++x);
  }

  void doStuff(int s){
    s+=EASY+ ++s;
    System.out.println("s "+s);
  }
}
