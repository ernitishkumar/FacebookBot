public class e13{
  public static void main(String[] args) {
    Sente a = new Sente(); a.go();
    Goban b = new Goban(); b.go();
    Stone c = new Stone(); c.go();
  }
}

class Sente implements Go{
  public void go(){
    System.out.println("go in sente");
  }
}

class Goban extends Sente{
  public void go(){
    System.out.println("go in goban");
  }
}

class Stone extends Goban implements Go{

}

interface Go{
  public void go();
}
