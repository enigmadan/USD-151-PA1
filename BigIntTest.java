import java.io.*;
import java.util.Scanner;
public class BigIntTest {
  public static void main(String [] args){
    String input = args[0];
    String output = args[1];
    String operator;
    ObjectInputStream ioStream = null;
    ObjectOutputStream ooStream = null;
    if (!(args.length == 2)){
      System.err.println("Usage: java BigIntTest infile outfile");
      System.exit(1);
    }
    try{
      ioStream = new ObjectInputStream( new FileInputStream(input));
      Scanner s = new Scanner(ioStream);
      BigInt bi1 = new BigInt(s.next());
      operator = s.next();
      BigInt bi2 = new BigInt(s.next());


  
    }
    catch(IOException e){
      System.err.println("The file '"+input+"' could not be opened for reading.");
      System.exit(1);
    }

  }

}
