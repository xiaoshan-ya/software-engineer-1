
import static org.junit.Assert.*;

import org.junit.Test;

public class PowerOfTwoTest {

	@Test
	public void testPowerA() {
		assertEquals(true, PowerOfTwo.isPowerOfTwo(4));
	}
	
	@Test
	public void testPowerB() {
		assertEquals(false, PowerOfTwo.isPowerOfTwo(5));
	}
	
	@Test
	public void testZero() {
		assertEquals(false, PowerOfTwo.isPowerOfTwo(0));
	}
	
	@Test
	public void testOne() {
		assertEquals(true, PowerOfTwo.isPowerOfTwo(1));
	}
	
	@Test
	public void testNegative() {
		assertEquals(false, PowerOfTwo.isPowerOfTwo(-2));
	}
	
}
