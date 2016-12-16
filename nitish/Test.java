import java.util.Date;
import java.text.*;
public class Test{

public static void main(String gg[])
{
SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyyHHmmss");
String date =  sdf.format(new Date());
System.out.println(date);
}
}