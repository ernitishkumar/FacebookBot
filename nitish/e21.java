import java.util.*;
public class e21{
  public static void main(String[] args) {

  }

  public void takeList(List<? extends String> list){
    //=list.add("Hello");
    Object o = list;
    String s = list.get(0);
    list = new ArrayList<String>();
    //list = new ArrayList<Object>();
  }
}
