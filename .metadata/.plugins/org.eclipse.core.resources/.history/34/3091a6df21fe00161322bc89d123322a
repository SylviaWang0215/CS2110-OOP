
public class ThrowStatement {
	/*
	public static void main(String[] args){
		try {
			//int y = 5/0;
			//System.out.println("try statement");
			throw new ArithmeticException("args shoule be not negative");
		}
		catch (ArithmeticException ae) {
			System.out.println("catch statement");
			System.out.println(ae);
			//throw new ArithmeticException("catch statement");
		}
	}
	
	
	public static void main(String[] args){
		//p(-1);
		int [] arr;
		int [] arr2 = new int[0];
		arr = new int[5];
		arr[1] = 1;
		arr[2] = 2;
		arr[3] = 3;
		arr[4] = 4;
		arr[0] = 5;
		//min1(arr, 3, 3);
		//min2(arr2);
		first(6);
	}*/
	
	public static void main(String[] args){
		/**Print the sum of two integers read from the keyboard*/
		System.out.println("enter a number");
		String s = "a12";
		int a = 0;
		int b = 0;
		try{
			a = Integer.parseInt(s);
			throw new NumberFormatException();
		}catch (Exception e){
			a = 1;
		}
		
		System.out.println("Enter another number:");
		try{
			b = Integer.parseInt(s);
			throw new NumberFormatException();
		}catch (Exception e){
			b = 1;
		}
		System.out.println("Product:" + a*b);
		
	}
	
	public static double p(int x){
		int y = x;
		try{
			System.out.println("six");
			y = 5/x;
			System.out.println("five");
			return 5/(x+2);
		}
		catch (RuntimeException e){
			System.out.println("four");
			y = 5/(x+1);
			System.out.println("three");
		}
		System.out.println("two");
		y = 4/x;
		System.out.println("one");
		return 1/x;
	}
	
	public static int min1(int[] c, int m, int n){
		if(m == n) throw new RuntimeException("min of 0 values doesn't exist");
		int min = c[m];
		for (int k = m+1; k<= n; k=k+1){
			if (c[k] < min) min=c[k];
		}
		System.out.println("finish!");
		return min;
	}
	
	public static int min2(int[] c){
		try{
			int min = c[0];
			for (int k=0; k < c.length; k = k +1){
				if (c[k] < min) min = c[k];
			}
			return min;
		}
		catch (ArrayIndexOutOfBoundsException e){
			throw new RuntimeException("min of 0 values doesn't exist");
		}
	}
	
	public static void first(int k){
		try{
			System.out.println("0");
			second(k);
			System.out.println("1");
		}catch(Exception e){
			System.out.println("2");
		}
	}
	
	public static void second(int p) throws Exception{
		System.out.println("3");
		try{
			int b = 5/p;
			System.out.println("4");
			if(p == 6) throw new Exception();
			System.out.println("5");
		}catch(ArithmeticException e){
			System.out.println("6");
		}
		System.out.println("7");
		
		
	}
}
