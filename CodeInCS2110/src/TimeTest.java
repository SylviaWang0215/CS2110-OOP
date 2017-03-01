import static org.junit.Assert.*;

import org.junit.Test;

public class TimeTest {

	@Test
	public void test() {
		Time x = new Time(1, 2);
		try{
			x.printitout(20);
			System.out.println("finish try");
			
		}
		catch (Exception e){
			int y = 5;
			y = y / 1;
			System.out.println("finish catch");
		}
		System.out.println("statement3!");
	}

}
