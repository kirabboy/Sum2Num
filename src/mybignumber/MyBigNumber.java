
package mybignumber;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Tác giả: Nguyễn Chính Hưng
 * MyBigNumber là lớp để Cộng 2 số lớn bằng 2 chuỗi. 
 * MyBigNumber là hàm để thực hiện phép cộng 2 chuỗi số
 */
public class MyBigNumber {
    
    private IReceiver ireceiver;
   
    public MyBigNumber(final IReceiver ireceiver) {
        this.ireceiver = ireceiver;
    }   
    
    /**
     * Hàm sum là hàm thực hiện cộng 2 số
     * 2 chuỗi này đều chỉ chứa các kí số từ '0' đến '9'.
     *
     * @param s1 chuỗi số thứ nhất.
     * @param s2 chuỗi số thứ hai.
     * @return chuỗi có giá trị là tổng của hai số s1 và s2.
     */
    public String sum(final String s1,final String s2) {
        String result = "";//String contain the final result  
        String step = ""; //String contain the step = 
        int s1length = s1.length();//variable get a length of s1
        int s2length = s2.length();//variable get a length of s2
        final String pattern = "\\d+";//pattern
        final boolean isError1;//erro1
        final boolean isError2;//erro2
        int temp = 0;// variable get memorize
        int max = 0;//variable get  larger lengths
        int char1;//variable get  number1
        int char2;//variable get  number2
        int s = 0;//variable get sum of number1 number 2 and temp
        int i;//variable count
        String blank = "";//String get blank to equal
        
        try {
            if (s1.equals(blank)) {
                this.ireceiver.send("Enter first number: ");
                throw new NumberFormatException("Please enter the first number!!!");
            }

            if (s2.equals(blank)) {
                this.ireceiver.send("Enter second number: ");
                throw new NumberFormatException("Please enter the second number!!!");
            }
           
            if (s1.charAt(0) == '-') {
                this.ireceiver.send("Please enter the first number as a positive number: " + s1);
                throw new NumberFormatException("Please enter the first number as a positive number: " + s1);
            }

            if (s2.charAt(0) == '-') {
                this.ireceiver.send("Please enter the  number as a positive number: " + s2);
                throw new NumberFormatException("Please enter the first number as a positive number: " + s2);
            }
          
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
            
            return "error";
        }
        
        max = (s1length > s2length) ? s1length : s2length;
        
        for (i = 0 ; i < max; i++) {
            char1 = (s1length - i - 1 >= 0) ? (s1.charAt(s1length - i - 1) - '0') : 0;
            char2 = (s2length - i - 1 >= 0) ? (s2.charAt(s2length - i - 1) - '0') : 0;
            s = char1 + char2 + temp;
            result = (s % 10) + result;
            step = " Step " + (i + 1) + ":\n "
                + char1 + " + " + char2 + " = " + (s - temp) + " ; "
                + (s - temp) + " + " + temp + " = " + s
                + "; Wirte " + s % 10 + " memorize " + s / 10 
                + " .result: " + result + ".\n";
            
            temp = s / 10;

            this.ireceiver.send(step);
        }
        
        if (temp > 0) {
            step = "Step " + (i + 2) + ":\n" + 0 + " + " + 0 + temp + " = " + 1 + ".\n" ;
            result = temp + result;
            this.ireceiver.send(step);
        }
        step = "result: " + result + "\n";
        this.ireceiver.send(step);
        
        return result;
    }
}