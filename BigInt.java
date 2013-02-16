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
	int d =1;
	int thisDigit;
	int biDigit;
	int sum;
	String finalSum="";
	if(bi.val.length()<=val.length()){
		while(val.length()-d>=0){
		 thisDigit = Integer.parseInt(val.substring(val.length()-d,val.length()-d));
	     biDigit = Integer.parseInt(bi.val.substring(bi.val.length()-d,bi.val.length()-d));
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
		while(bi.val.length()-d>=0){
			 thisDigit = Integer.parseInt(val.substring(val.length()-d,val.length()-d));
		     biDigit = Integer.parseInt(bi.val.substring(bi.val.length()-d,bi.val.length()-d));
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
	int thisDigit;
	int biDigit;
	int tens;
	int product;
	String tempProduct="";
	
	//start a multiplication, iterate through digits of caller
	for(int d = 1;d<val.charAt(val.length());d++){
		//get current digit for caller
		thisDigit = val.charAt(val.length()-d);
		//iterate through digits of parameter
		for(int i = 1;i<bi.val.charAt(bi.val.length());i++){
			//get current digit of parameter
			biDigit = bi.val.charAt(bi.val.length()-i);
			//multiply current digits 
			product = thisDigit*biDigit+temp;
			tempProduct = Integer.toString((product % 10)) + tempProduct;
			temp = product/10;
		}
		
	}
	
	/*
	 //why would we initialize and define a BigInt here?
	  * 
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
	*/
}
//just for fun, I'm going to try to put in some values to see what happens.

//say that we call with BigInt '65781' and we use BigInt '8723' as our parameter
public BigInt multiply(BigInt bi){
	int multi=0;
	int temp = 0;
	int finalMulti = 0;
	for(int x=0;x<this.val.length()-1;x++){
		int  thisDigit= Character.digit(this.val.charAt(x), 10);
		//first iteration through we get the 6 from BigInt '65781'
		//second iteration through we get the 5 from BigInt '65781'
		//third iteration through we get the 7 from BigInt '65781'
		//fourth iteration through we get the 8 from BigInt '65781'
		//fifth iteration through we get the 1 from BigInt '65781'
		
		
		for(int y=0;y<bi.val.length()-1;y++){
			int  biDigit= Character.digit(bi.val.charAt(y), 10);
			//first iteration through we get the 8 from BigInt '8723'
			//second iteration through we get the 7 from BigInt '8723'
			//third iteration through we get the 2 from BigInt '8723'
			//fourth iteration through we get the 3 from BigInt '8723'
			
			multi = thisDigit*biDigit; //multi from left to right
			//the 6 iteration
			//first time through we get 48 from 6*8
			//second time through we get 42 from 6*7
			//third time through we get 12 from 6*2
			//fourth time through we get 18 from 6*3
			//the 5 iteration
			//first time through we get 40 from 5*8
			//second time through we get 35 from 5*7
			//third time through we get 10 from 5*2
			//fourth time through we get 15 from 5*3
			//the 7 iteration
			//first time through we get 56 from 7*8
			//second time through we get 49 from 7*7
			//third time through we get 14 from 7*2
			//fourth time through we get 21 from 7*3
			//the 8 iteration
			//first time through we get 64 from 8*8
			//second time through we get 56 from 8*7
			//third time through we get 16 from 8*2
			//fourth time through we get 24 from 8*3
			//the 1 iteration
			//first time through we get 8 from 1*8
			//second time through we get 7 from 1*7
			//third time through we get 2 from 1*2
			//fourth time through we get 3 from 1*3
		
			temp=temp*10+multi; //will the number be too big to calculate by int type?
			//the 6 iteration
			//first time through we get 48 from 0+48
			//second time through we get 522 from 480+42
			//third time through we get 5232 from 5220+12
			//fourth time through we get 52338 from 52320+18
			//the 5 iteration
		//I'm going to assume that you re-initialize temp to '0' or else we might have a problem here.
			//first time through we get 40 from 0+40
			//second time through we get 435 from 400+35
			//third time through we get 4360 from 4350+10
			//fourth time through we get 43615 from 43600+15
			//the 7 iteration
			//first time through we get 56 from 0+56
			//second time through we get 609 from 560+49
			//third time through we get 6104 from 6090+14
			//fourth time through we get 61061 from 61040+21
			//the 8 iteration
			//first time through we get 64 from 0+64
			//second time through we get 696 from 640+56
			//third time through we get 6976 from 6960+16
			//fourth time through we get 69784 from 69760+24
			//the 1 iteration
			//first time through we get 8 from 0+8
			//second time through we get 87 from 80+7
			//third time through we get 872 from 870+2
			//fourth time through we get 8723 from 8720+3
			
			}
		finalMulti= finalMulti*10+temp;
		//first time through we get 52338 from 0 + 52338
		//second time through we get 95953 from 523380 + 43615
		//third time through we get 157014 from 95953 + 61061
		//fourth time through we get 226798 from 157014 + 69784
		//fifth time through we get 235521 from 226798 + 8723
	}
	String s = Integer.toString(finalMulti);
	return new BigInt(s);
	//would return '235521' as a BigInt
	//only problem is, when you multiply 65781 and 8723, you get a different number altogether.
	//unless I did some math wrong (which is highly likely, please check before changing anything),
	//this version will not find the correct product of two BigInts
}

	
}
