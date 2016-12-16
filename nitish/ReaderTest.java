import java.nio.file.*;
import java.io.*;
import java.util.*;
import java.nio.charset.*;
public class ReaderTest{
  public static void main(String[] args) {
    Path fileToParse = Paths.get("D:\\eas\\uploads\\25SE DL.TXT");
			try{
				List<String> records = Files.readAllLines(fileToParse, StandardCharsets.UTF_16);
				for(String line : records){
					System.out.println("Line from Files.readAllLines is: ");
					System.out.println(line);
          break;
				}
			}catch(IOException ioException){
				System.out.println("IOException in class : BillFileParser : method : parseBillFile(String) : "+ioException);
				ioException.printStackTrace();
			}catch(Exception exception){
				System.out.println("Exception in class : BillFileParser : method : parseBillFile(String) : "+exception);
				exception.printStackTrace();
			}
  }
}
