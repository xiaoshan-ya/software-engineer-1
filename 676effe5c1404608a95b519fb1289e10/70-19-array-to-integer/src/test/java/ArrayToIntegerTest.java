
import static org.junit.Assert.*;

import org.junit.Test;

public class ArrayToIntegerTest {

	@Test
	public void testPositive() {
		assertEquals(54321, ArrayToInteger.getInteger(new int[]{5,4,3,2,1}));
	}
	
	@Test
	public void testOverflow() {
		assertEquals(2147483647, ArrayToInteger.getInteger(new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1}));
	}
	
	@Test
	public void testZeros() {
		assertEquals(0, ArrayToInteger.getInteger(new int[]{0,0,0,0,0,0,0,0,0,0}));
	}
	
	@Test
	public void testLeadingZeros() {
		assertEquals(1000, ArrayToInteger.getInteger(new int[]{0,0,0,0,0,0,1,0,0,0}));
	}
}
