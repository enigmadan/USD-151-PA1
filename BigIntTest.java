import java.io.*;
import java.util.Scanner;
public class testr {
    public static void main(String [] args){
        if (!(args.length == 2)){
            System.err.println("Usage: java BigIntTest infile outfile");
            System.exit(1);
        }
        try{
            FileReader src = new FileReader(args[0]);
            PrintWriter pw = new PrintWriter(args[1]);
            Character operator;
            //idea string tokenizer
           

        Scanner s = new Scanner(src);
       
            while (s.hasNext()){
               
                BigInt bi1 = new BigInt(s.next());
                operator = (s.next()).charAt(0);
                BigInt bi2 = new BigInt(s.next());
                pw.println(BigInt.printProb(bi1, operator, bi2));
            }

        }
        catch(IOException e){
            System.err.println("The file '"+args[0]+"' could not be opened for reading.");
            System.exit(1);
        }

        System.out.println("Done!");
    }

}
