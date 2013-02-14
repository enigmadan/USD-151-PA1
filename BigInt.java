import java.util.Scanner;


public class BigInt {

	private String val;
	public BigInt(String val){
	this.val=val;	
	toString();
		
	}
	public  String toString(){
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
			while(val.substring(temp,temp)==bi.val.substring(temp,temp)){
				temp++;
				if(temp>l1){
					return this;
				}
			}
			int thisDigit = Integer.parseInt(val.substring(temp,temp));
			int biDigit= Integer.parseInt(bi.val.substring(temp,temp));
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
			while(val.substring(temp,temp)==bi.val.substring(temp,temp)){
				temp++;
				if(temp>l1){
					return this;
				}
			}
			int thisDigit = Integer.parseInt(val.substring(temp,temp));
			int biDigit= Integer.parseInt(bi.val.substring(temp,temp));
			if(thisDigit>biDigit){
				return bi;
			}
			else{
				return this;
			}
		}
	}
public BigInt add(BigInt bi){
	int temp = 0;
	int digit =1;
	int thisDigit;
	int biDigit;
	int sum;
	String finalSum="";
	if(bi.val.length()<=val.length()){
		while(val.length()-digit>=0){
		 thisDigit = Integer.parseInt(val.substring(val.length()-digit,val.length()-digit));
	     biDigit = Integer.parseInt(bi.val.substring(bi.val.length()-digit,bi.val.length()-digit));
	     if(biDigit<0){
	    	 biDigit=0;
	     }
	     sum = thisDigit+biDigit+temp;
		 temp = 0;
	     if(sum>9){
	    	 sum-=10;
	    	 temp=1;
	     }
	     
	    
	     finalSum= Integer.toString(sum)+finalSum;
		}
	}
	else{
		while(bi.val.length()-digit>=0){
			 thisDigit = Integer.parseInt(val.substring(val.length()-digit,val.length()-digit));
		     biDigit = Integer.parseInt(bi.val.substring(bi.val.length()-digit,bi.val.length()-digit));
		     if(thisDigit<0){
		    	 thisDigit=0;
		     }
		     sum = thisDigit+biDigit+temp;
			 temp = 0;
		     if(sum>9){
		    	 sum-=10;
		    	 temp=1;
		     }
		     
		    
		     finalSum= Integer.toString(sum)+finalSum;
			}
		
	}
	return new BigInt(finalSum);
}

public BigInt multiply(BigInt bi){
	int temp = 0;
	int digit =1;
	int thisDigit;
	int biDigit;
	int multi;
	int d=1;
	String finalMulti="";
	BigInt finalInt= new BigInt("0");
	if(bi.val.length()<=val.length()){
		
		while(bi.val.length()-digit>=0){
			biDigit = Integer.parseInt(bi.val.substring(bi.val.length()-d,bi.val.length()-d));
		while(val.length()-digit>=0){
		 thisDigit = Integer.parseInt(val.substring(val.length()-digit,val.length()-digit));
	     //biDigit = Integer.parseInt(bi.val.substring(bi.val.length()-digit,bi.val.length()-digit));
	 
	     multi = thisDigit*biDigit+temp;
		 temp = 0;
	     if(multi>9){
	    	
	    	 temp= multi/10;
	    	 multi=multi%10;
	     }
	     
	    
	     finalMulti= Integer.toString(multi)+finalMulti;
		}
		d++;
		BigInt finalMultiInt= new BigInt("finalMulti");		
		finalInt= finalInt.add(finalMultiInt);
		
	}
	}
	else{
		while(this.val.length()-digit>=0){
			thisDigit = Integer.parseInt(val.substring(val.length()-d,bi.val.length()-d));
		while(bi.val.length()-digit>=0){
		 biDigit = Integer.parseInt(bi.val.substring(bi.val.length()-digit,bi.val.length()-digit));
	     //biDigit = Integer.parseInt(bi.val.substring(bi.val.length()-digit,bi.val.length()-digit));
	 
	     multi = thisDigit*biDigit+temp;
		 temp = 0;
	     if(multi>9){
	    	
	    	 temp= multi/10;
	    	 multi=multi%10;
	     }
	     
	    
	     finalMulti= Integer.toString(multi)+finalMulti;
		}
		d++;
		BigInt finalMultiInt= new BigInt("finalMulti");		
		finalInt= finalInt.add(finalMultiInt);
		
	}
			}
		
	
	return finalInt;
}

	
	
	
}
