import java.util.zip.DataFormatException;

/**
 * File: BigInt.java
 * 
 * @author Mingyu Chen
 * @author Daniel Myers
 * @version 2/21/2013
 * 
 *          Description: Class to Manipulate Large Integers
 */
public class BigInt 
{
    private String val;

	/**
	 * Reduce and then Convert a string of numbers to a BigInt type
	 * 
	 * @param String
	 * @throws DataFormatException Defined here. Throws if there is an attempt to 
	 * initialize BigInt as a non-integer
	 */
	public BigInt(String s) throws DataFormatException
	{
		//make sure there are no leading zeroes
		this.val = reduce(s);
		for(int i = 0;i<s.length();i++)
		{
			//make sure val is an Integer
			if(!(Character.isDigit(s.charAt(i))))
			{ 
				throw new DataFormatException("_*_Could not parse BigInt '" +s+
						"' (not a valid integer)"); 
			} 
		}
	}

	/**
	 * Returns a string with no leading zeroes
	 * 
	 * @param String
	 *            s
	 * @return String
	 */
	private String reduce(String s) 
	{
		int remove = 0;
		//increment down the length of String s
		while (remove < s.length()) 
		{
			//check if char is not 0 
			if (s.charAt(remove) != '0') 
			{
				break;
			}
			//add to remove, go to next character in String s 
			remove++;
		}
		//This means that the string was full of zeroes
		if (s.length() == remove) 
		{
			s = "0";
		} 
		else 
		{
			//remove everything we counted earlier (should only be leading zeroes)
			s = s.substring(remove);
		}
		return s;
	}

	/**
	 * toString method for printing
	 */
	public String toString() 
	{
		return val;
	}

	/**
	 * Finds the larger of two BigInts
	 * 
	 * @param BigInt
	 *            bi
	 * @return The larger of two BigInt. Or, if equal, return calling object
	 */
	public BigInt max(BigInt bi) 
	{
		int l1 = this.val.length();
		int l2 = bi.val.length();
		if (l1 < l2) 
		{
			return bi;
		} 
		else if (l1 > l2) 
		{
			return this;
		} 
		else 
		{
			for (int i = 0; i < l1; i++) 
			{
				int thisDigit = Character.digit(val.charAt(i), 10);
				int biDigit = Character.digit(bi.val.charAt(i), 10);
				if (thisDigit < biDigit) 
				{
					return bi;
				} 
				else if (thisDigit > biDigit) 
				{
					break;
				}
			}
			return this;
		}
	}

	/**
	 * Finds the smaller of two BigInts
	 * 
	 * @param BigInt
	 *            bi
	 * @return the smaller of two BigInt. Or, if equal, return calling object
	 */
	public BigInt min(BigInt bi) 
	{
		int l1 = this.val.length();
		int l2 = bi.val.length();
		if (l1 > l2) {
			return bi;
		} 
		else if (l1 < l2) 
		{
			return this;
		} 
		else 
		{
			for (int i = 0; i < l1; i++) 
			{
				int thisDigit = Character.digit(val.charAt(i), 10);
				int biDigit = Character.digit(bi.val.charAt(i), 10);
				if (thisDigit > biDigit) 
				{
					return bi;
				} 
				else if (thisDigit < biDigit) 
				{
					break;
				}
			}
			return this;
		}
	}

	/**
	 * Finds the sum of two BigInts
	 * 
	 * @param BigInt
	 *            bi
	 * @return Sum of two BigInt
	 * @throws DataFormatException If there is an attempt to 
	 * initialize BigInt as a non-integer
	 */
	public BigInt add(BigInt bi) throws DataFormatException 
	{
		String s1 = this.val;
		String s2 = bi.val;
		try
		{
			//calls addS to add the two Strings
			return new BigInt(addS(s1, s2));
		}
		catch(DataFormatException e)
		{
			throw e;
		}
	}

	/**
	 * Finds and returns the sum of two Strings
	 * 
	 * @param String
	 *            s1
	 * @param String
	 *            s2
	 * @return sum of String s1 and String s2
	 */
	private static String addS(String s1, String s2) 
	{
		int temp = 0;
		int thisDigit;
		int biDigit;
		int sum;
		String finalSum = "";
		if (s2.length() <= s1.length()) 
		{
			for (int d = 1; s1.length() - d >= 0; d++) 
			{
				//if the shorter of the numbers still has digits left
				if (!(s2.length() - d < 0)) 
				{
					biDigit = Character.digit(s2.charAt(s2.length() - d), 10);
				} 
				else 
				{
					biDigit = 0;
				}
				thisDigit = Character.digit(s1.charAt(s1.length() - d), 10);
				sum = thisDigit + biDigit + temp;
				temp = 0;
				if ((sum > 9) && ((s1.length() - d) != 0)) 
				{
					sum -= 10;
					temp = 1;
				}
				finalSum = Integer.toString(sum) + finalSum;
			}
		} 
		
		else 
		{
			for (int d = 1; s2.length() - d >= 0; d++) 
			{				
				//if the shorter of the numbers still has digits left
				if (!(s1.length() - d < 0)) 
				{
					thisDigit = Character.digit(s1.charAt(s1.length() - d), 10);
				} else 
				{
					thisDigit = 0;
				}
				biDigit = Character.digit(s2.charAt(s2.length() - d), 10);
				sum = thisDigit + biDigit + temp;
				temp = 0;
				if (sum > 9 && ((s2.length() - d) != 0)) 
				{
					sum -= 10;
					temp = 1;
				}
				finalSum = Integer.toString(sum) + finalSum;
			}
		}
		return finalSum;
	}

	/**
	 * Find the product of two BigInts
	 * 
	 * @param BigInt
	 *            bi
	 * @return product of two BigInt
	 * @throws DataFormatException If there is an attempt to 
	 * initialize BigInt as a non-integer
	 */
	public BigInt multiply(BigInt bi) throws DataFormatException 
	{
		int multi = 0;
		String tempS = "0";
		String finalMulti = "0";
		for (int x = 0; x < this.val.length(); x++) 
		{
			int thisDigit = Character.digit(this.val.charAt(x), 10);
			for (int y = 0; y < bi.val.length(); y++) 
			{
				int biDigit = Character.digit(bi.val.charAt(y), 10);
				multi = thisDigit * biDigit; // multiply from left to right
				tempS = addS(String.valueOf(multi), tempS + "0");
			}
			//use the addS method to add up all of the strings
			finalMulti = addS(finalMulti + "0", tempS);
			tempS = "0";
		}
		try
		{
			return new BigInt(finalMulti);
		}
		catch(DataFormatException e)
		{
			throw e;
		}
	}

	/**
	 * A method used to find the solution when each operator is used
	 * 
	 * @param BigInt
	 *            b1
	 * @param Character
	 *            op
	 * @param BigInt
	 *            b2
	 * @return a string with the original problem and the solution formatted as
	 *         'b1 operator b2 = [solution]'
	 * @throws DataFormatException If there is an attempt to 
	 * initialize BigInt as a non-integer
	 * @throws InterruptedException Defined here. If op is not a valid operator
	 */
	public static String printProb(BigInt b1, Character op, BigInt b2) throws DataFormatException, InterruptedException
	{
		if(!((op=='+')||(op=='-')||(op=='*')||(op=='>')||(op=='<')))
		{
			throw new InterruptedException("'"+op+"' is not a valid operator");	
		}
		try
		{
			BigInt result = new BigInt("");
			if (op == '+') {
				result = b1.add(b2);
			}
			if (op == '*') {
				result = b1.multiply(b2);
			}
			if (op == '>') {
				result = b1.max(b2);
			}
			if (op == '<') {
				result = b1.min(b2);
			}
			return (b1 + " " + op + " " + b2 + " " + "=" + " " + result);
		}
		catch(DataFormatException e)
		{
			throw e;
		}
	}
}
