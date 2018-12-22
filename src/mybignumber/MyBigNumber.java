
package mybignumber;
 
public class MyBigNumber {
    public IReceiver ireceiver;
   
    public MyBigNumber(IReceiver ireceiver) {
        this.ireceiver = ireceiver;
    }   
    
    public String sum (final String s1,final String s2) {
        String result="";
        String step="";
        int s1_length=s1.length();
        int s2_length=s2.length();
        final String pattern = "\\d+";
        final boolean isError1;
        final boolean isError2;
        int temp=0;
        int max=0;
        int char1,char2;
        int s=0;
        int i;
        
        //Kiểm tra dữ liệu nhập 
        try {
        	//Kiểm tra xem người dùng đã nhập input 
            if (s1.equals("")) {
                this.ireceiver.send("Enter first number: ");
                throw new NumberFormatException("Please enter the first number!!!");
            }

            if (s2.equals("")) {
                this.ireceiver.send("Enter second number: ");
                throw new NumberFormatException("Please enter the second number!!!");
            }
           
            //Kiểm tra có số âm hay không
            if (s1.charAt(0) == '-') {
                this.ireceiver.send("Please enter the first number as a positive number: " + s1);
                throw new NumberFormatException("Please enter the first number as a positive number: " + s1);
            }

            if (s2.charAt(0) == '-') {
                this.ireceiver.send("Please enter the  number as a positive number: " + s2);
                throw new NumberFormatException("Please enter the first number as a positive number: " + s2);
            }
          
            //Kiểm tra có ký tự đặc biệt hay không
            isError1 = s1.matches(pattern);
            isError2 = s2.matches(pattern);

            if (!isError1) {
                this.ireceiver.send("Please do not enter symbols in first numbers: " + s1);
                throw new NumberFormatException("Please do not enter symbols in first numbers : " + s1);
            }

            if (!isError2) {
                this.ireceiver.send("Please do not enter symbols in second numbers : " + s2);
                throw new NumberFormatException("Please do not enter symbols in second numbers : " + s2);

            }
        } catch (NumberFormatException e) {
            System.out.println(e);
            
            return "error";
        }
        
        //Lấy độ dài số lớn hơn
        max = (s1_length>s2_length) ? s1_length : s2_length;
        
        //Thực hiện cộng 2 
        for( i = 0 ; i < max; i++){
        	
        	char1 = (s1_length-i-1 >= 0) ? (s1.charAt(s1_length-i-1)-'0') : 0;
        	char2 = (s2_length-i-1 >= 0) ? (s2.charAt(s2_length-i-1)-'0') : 0;
        	
        	s 	= char1+char2+ temp;
        	result 	= (s % 10) + result;

        	// In ra các bước tính 
        	step = " Step " + (i + 1) + ":\n "
        			+ char1 + " + " + char2 + " = " + (s - temp)+ " ; "
        			+ (s-temp) + " + " + temp + " = " + s
        			+ "; Wirte " + s % 10 + " memorize " + s / 10 
        			+ " .result: "+result + ".\n";
     
        	temp = s/10;

            this.ireceiver.send(step);
        }
        //Nếu nhớ>0 thì in ra bước này và cộng thêm vào kết quả
        if(temp > 0){
        	step="Step " +(i+2) +":\n" + 0 + " + " + 0 + temp + " = " + 1+ ".\n" ;
            result = temp + result;
            this.ireceiver.send(step);
        }
        step="result: "+result + "\n";
        this.ireceiver.send(step);
        
        return result;
    }
}





