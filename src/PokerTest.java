import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class PokerTest {

    @Test
    public void test() {
        fail("Not yet implemented");
    }


    @Test
    public void winTest() {

        boolean z = new Poker().win(0, 1);
        assertEquals(false, z);

        boolean z1 = new Poker().win(0, 1);
        assertEquals(false, z1);

        boolean z2 = new Poker().win(0, 1);
        assertEquals(false, z2);

        boolean z3 = new Poker().win(0, 1);
        assertEquals(false, z3);

    }


    @After
    public void after() {
        System.out.println("after");
    }


}
