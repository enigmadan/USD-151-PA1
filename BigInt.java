import java.util.Scanner;


public class BigInt {

	private String val;
	
	public BigInt(String s){
			this.val=s;
			//toString();
	}
	public void biPrint(){
		System.out.println(val);
	}
	
	public String toString(){
		Scanner sc = new Scanner(val);
		sc.useDelimiter("");
		int length = val.length();
		int remove = 0;
		while(sc.hasNext()){
			if(sc.next()!="0")
			{
				break;
			}

			remove++;

		}
		if(length==remove)
		{
			val = "0";

		}
		else{
			val.substring(remove);
		}
		return val;

		/*Char[] a =new Character[];
a = val.toCharArray();
if(a[0]!='0')
{
return val;
}
else{
for(int x=0, y=0;x<a.length;x++,y++)
{
if(a[x]!='0'){
Char[] b= new character[];
b[y]= a[x];
}
String val2 = new String(b);
return val2;
else {
return "0";
}
}
}
}
		 */
	}
	public BigInt max(BigInt bi){

		int l1= this.val.length();
		int l2 = bi.val.length();
		if(l1>l2){
			return this;
		}
		else if(l1<l2){
			return bi;
		}
		else{
			int temp = 0;
			while(val.charAt(temp)==bi.val.charAt(temp)){
				temp++;
				if(temp>l1){
					return this;
				}
			}
			int thisDigit = Character.digit(val.charAt(temp),10);
			int biDigit= Character.digit(bi.val.charAt(temp),10);
			if(thisDigit>biDigit){
				return this;
			}
			else{
				return bi;
			}
		}
	}
	
	public BigInt min(BigInt bi){

		int l1= this.val.length();
		int l2 = bi.val.length();
		
		if(l1>l2){
			return bi;
		}
		else if(l1<l2){
			return this;
		}
		else{
			int temp = 0;
			while(val.charAt(temp)==bi.val.charAt(temp)){
				temp++;
				if(temp>l1){
					return this;
				}
			}
			int thisDigit = Character.digit(val.charAt(temp),10);
			int biDigit= Character.digit(bi.val.charAt(temp),10);
			if(thisDigit>biDigit){
				return bi;
			}
			else{
				return this;
			}
		}
	}
	public BigInt add(BigInt bi){
		
		String s1 = this.val;
		String s2 = bi.val;
		return new BigInt(addS(s1, s2));
		
	}
	private static String addS(String s1, String s2){
		
		int temp = 0;
		int thisDigit;
		int biDigit;
		int sum;
		String finalSum="";
		
		if(s2.length()<=s1.length()){
			for(int d=1;s1.length()-d>=0;d++){
				if(!(s2.length()-d<0)){
					biDigit = Character.digit(s2.charAt(s2.length()-d),10);
				}else{
					biDigit=0;
				}
				thisDigit = Character.digit(s1.charAt(s1.length()-d),10);
				sum = thisDigit+biDigit+temp;
				temp = 0;
				if((sum>9)&&((s1.length()-d)!=0)){
					sum-=10;
					temp=1;
				}
				finalSum= Integer.toString(sum)+finalSum;
			}
		}
		else{
			for(int d=1;s2.length()-d>=0;d++){
				if(!(s1.length()-d<0)){
					thisDigit = Character.digit(s1.charAt(s1.length()-d),10);
				}else{
					thisDigit=0;
				}
				biDigit = Character.digit(s2.charAt(s2.length()-d),10);
				sum = thisDigit+biDigit+temp;
				temp = 0;
				if(sum>9&&((s2.length()-d)!=0)){
					sum-=10;
					temp=1;
				}
				finalSum= Integer.toString(sum)+finalSum;
			}
		}
		return finalSum;
	}
	
	/**
	 * 
	 * 
	 */
	
	public BigInt multiply(BigInt bi){
		
		int multi=0;
		String tempS = "0";
		String finalMulti = "0";
		
		for(int x=0;x<this.val.length();x++){
			
			int thisDigit = Character.digit(this.val.charAt(x), 10);

			for(int y=0;y<bi.val.length();y++){
				
				int biDigit= Character.digit(bi.val.charAt(y), 10);
				
				multi = thisDigit*biDigit; //multi from left to right
				tempS=addS(String.valueOf(multi),tempS+"0"); //will the number be too big to calculate by int type?
			}
			finalMulti = addS(finalMulti+"0",tempS);
			tempS = "0";
		}
		return new BigInt(finalMulti);
	}
}
