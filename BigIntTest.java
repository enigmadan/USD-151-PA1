import java.io.*;
import java.util.Scanner;
import java.util.zip.DataFormatException;
/**
 * File: BigIntTest.java
 * 
 * @author Mingyu Chen
 * @author Daniel Myers
 * @version 2/21/2013
 * 
 * Description: Uses BigInt class to solve a file of problems 
 * and output the solutions to another file
 */
public class BigIntTest 
{

    public static void main(String [] args)
	{
		//Check if there are not two command line arguments (infile and outfile)
		if (!(args.length == 2))
		{
			//If there are not exactly 2 args, let the user 
			//know that they didn't follow instructions
			System.err.println("Usage: java BigIntTest infile outfile");
			//and forcefully end the program
			System.exit(1);
		}
		//Try, and if you fail, try, try again...
		try{
			//open-ish first arg (should be input file)
			FileReader src = new FileReader(args[0]);
			//open-ish second arg (should be output file)
			PrintWriter pw = new PrintWriter(args[1]);
			//make a char to hold the operator (+, *, <, or >)
			Character operator;           
			//Initialize scanner
			Scanner s = new Scanner(src);
			//loop until 'EOF' (or at least until there is no 'next'
			while (s.hasNext())
			{
				try
				{
					//first element of 3 is first BigInt
					BigInt bi1 = new BigInt(s.next());
					//second element of 3 is operator
					operator = (s.next()).charAt(0);
					//third element of 3 is second BigInt
					BigInt bi2 = new BigInt(s.next());
					try
					{
						//print this line to our output file through an awesome method
						pw.println(BigInt.printProb(bi1, operator, bi2));
					}
					catch(InterruptedException ie)
					{
						pw.println(ie.getMessage());
						s.nextLine();
					}
				}
				catch(DataFormatException e){
					pw.println(e.getMessage());
					s.nextLine();
				}
			}
			//The best idea ever...
			src.close();
			pw.close();
			s.close();
		}
		//If there is a problem with the files, this will let you know about it
		catch(IOException e)
		{
			//lets you know which file had a problem
			System.err.println("There is an error with "+e.getMessage());
			//forcefully ends the program
			System.exit(1);
		}
		//In case you were wondering
		//System.out.println("Done!");
	}

}
