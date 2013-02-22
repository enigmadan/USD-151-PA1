/**
 *
 * @author Mingyu Chen
 * @author Daniel Myers
 *
 */
public class BigInt{

    private String val;

    /**
     *
     * @param String s
     */
    public BigInt(String s) {
        try{
            this.val=reduce(s);
        }
        catch(NumberFormatException e){

        }
    }

    private String reduce(String s){

        int remove = 0;
        for(int i=0;i<s.length()-1;i++){
            s.charAt(i);
        }
        while(remove<s.length()){
            if(s.charAt(remove)!='0')
            {
                break;
            }
            remove++;
        }
        if(s.length()==remove)
        {
            s = "0";
        }
        else{
            s = s.substring(remove);
        }
        return s;
    }

    /**
     *
     */
    public String toString(){


        return val;
    }


    /**
     *
     * @param BigInt bi
     * @return
     */
    public BigInt max(BigInt bi){

        int l1= this.val.length();
        int l2 = bi.val.length();

        if(l1<l2){
            return bi;
        }
        else if(l1>l2){
            return this;
        }
        else{
            for(int i = 0;i < l1;i++){

                int thisDigit = Character.digit(val.charAt(i),10);
                int biDigit = Character.digit(bi.val.charAt(i),10);

                if(thisDigit<biDigit){
                    return bi;
                }
                else if(thisDigit>biDigit){
                    break;
                }
            }
            return this;
        }
    }

    /**
     *
     * @param BigInt bi
     * @return the smaller of two BigInt
     */
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
            for(int i = 0;i < l1;i++){

                int thisDigit = Character.digit(val.charAt(i),10);
                int biDigit = Character.digit(bi.val.charAt(i),10);

                if(thisDigit>biDigit){
                    return bi;
                }
                else if(thisDigit<biDigit){
                    break;
                }
            }
            return this;
        }
    }

    /**
     *
     * @param BigInt bi
     * @return
     */
    public BigInt add(BigInt bi){

        String s1 = this.val;
        String s2 = bi.val;

        return new BigInt(addS(s1, s2));
    }

    /**
     *
     * @param String s1
     * @param String s2
     * @return
     */
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
     * @param BigInt bi
     * @return
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
                tempS=addS(String.valueOf(multi),tempS+"0");
            }
            finalMulti = addS(finalMulti+"0",tempS);
            tempS = "0";
        }
        return new BigInt(finalMulti);
    }
   
    public static String printProb(BigInt b1, Character op, BigInt b2 ){
       
        BigInt result = new BigInt("");
       
        if(op=='+'){
            result = b1.add(b2);
        }
        if(op=='*'){
            result = b1.multiply(b2);
        }
        if(op=='>'){
            result = b1.max(b2);
        }
        if(op=='<'){
            result = b1.min(b2);
        }
        return(b1+" "+op+" "+b2+" "+"="+" "+result);
    }
}
