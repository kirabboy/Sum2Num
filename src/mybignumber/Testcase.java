package mybignumber;

class Testcase implements IReceiver{
		public static void main(String[] args){
			
			Testcase1();
			Testcase2();
			Testcase3();
		}
			
			@Override
			public void send( String msg) {
				System.out.println(msg);
			}

			
			public static void Testcase1(){
				Testcase test= new Testcase();
				MyBigNumber mybignumber = new MyBigNumber(test);
				String s1="18112014";
				String s2="201823";
		        System.out.println("Testcase 1:");
		        mybignumber.sum(s1,s2);
			}
			
			public static void Testcase2(){
				Testcase test= new Testcase();
				MyBigNumber mybignumber = new MyBigNumber(test);
				String s1="11238921";
				String s2="1231231";	
		        System.out.println("Testcase 2");
				mybignumber.sum(s1, s2);
			}
			
			public static void Testcase3(){
				Testcase test= new Testcase();
				MyBigNumber mybignumber = new MyBigNumber(test);
				String s1="1234";
				String s2="123456789";
		        System.out.println("Testcase 3:");
				mybignumber.sum(s1, s2);
			}
			
}
