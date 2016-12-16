public class e15{
  public enum Dogs{
    collie,
    harrier
  };

  public static void main(String[] args) {
    Dogs myDog = Dogs.collie;
    switch(myDog){
      case collie :
                    System.out.println("collie");

     case default:
                    System.out.println("default");
      case harrier :
                    System.out.println("harrier");
    }
  }
}
