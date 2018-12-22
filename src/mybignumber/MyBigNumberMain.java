package mybignumber;

import java.util.Scanner;

public class MyBigNumberMain implements IReceiver {

	    public static void main(String[] args) {

	        MyBigNumberMain run = new MyBigNumberMain();
	        MyBigNumber mybignumber = new MyBigNumber(run);
	        Scanner sc = new Scanner(System.in);

	        System.out.print("Enter the first number: ");
	        String s1 = sc.nextLine();
	        System.out.print("Enter the second number: ");
	        String s2= sc.nextLine();
	        mybignumber.sum(s1,s2);
	    }

	  

		@Override
		public void send(String msg) {
		System.out.println(msg);

		}

}
