public class e9{
  public static void main(String gg[]){
    Gen<String> str = new Gen<String>("answer");
    System.out.println(str.getObject());
  }
}

class Gen<T>{
  private T object;
  public Gen(T object){
    this.object = object;
  }
  public T getObject(){
    return object;
  }
}
