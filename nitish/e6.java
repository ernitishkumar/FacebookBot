public class e6{
  public static void main(String gg[]){
        Base b = new Base();
        Sub s = new Sub();
        System.out.print(Base.FOO);
        System.out.print(Sub.FOO);
        System.out.print(b.FOO);
        System.out.print(s.FOO);
        System.out.print(((Base)s).FOO);
  }
}
class Base{
  public static final String FOO = "foo";
}

class Sub extends Base{
  public static final String FOO = "bar";
}
