package test;

import mybignumber.MyBigNumber;
import org.junit.Assert.*;

/**
 *
  @author Kira
 * this classes use for testing function MyBigNumber
 */
public class MyBigNumberTest {
    
    public MyBigNumberTest() {
    }
    
     @Test
     public void test1() throws Exception 
     {
         MyBigNumber mybignumber = new MyBigNumber();
         String str = mybignumber.sum("123123", "321");
         String result = "123444";
         assertEquals("pass",result,str);
     }
     
     @Test
     public void test2() throws Exception 
     {
         MyBigNumber mybignumber = new MyBigNumber();
         String str = mybignumber.sum("123123", "0");
         String result = "123444";
         assertEquals("pass",result,str);
     }
     

     
     @Test
     public void test3() throws Exception 
     {
         MyBigNumber mybignumber = new MyBigNumber();
         String str = mybignumber.sum("0", "0");
         String reult = "0";
         assertEquals("pass",result,str);
     }
     
     @Test
     public void test4() throws Exception 
     {
         MyBigNumber mybignumber = new MyBigNumber();
         String str = mybignumber.sum("/", "???");
         String exception =("Please do not enter symbols in first numbers");
         assertEquals("pass",exception,str);
     }
     
}