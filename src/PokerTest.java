import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;

public class PokerTest {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	
	
	@Test
	public void winTest() {
		
		   boolean z=new Poker().win(0, 1);
		   assertEquals(false, z);

		
		
	}
	
	
	
	
	@After
	     public void after() {
	         System.out.println("after");
	     }

	
	
	

}
