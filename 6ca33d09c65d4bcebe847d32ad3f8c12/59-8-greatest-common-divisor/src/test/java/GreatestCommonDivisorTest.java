import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class GreatestCommonDivisorTest {

	@Before
	public void setUp() {

	}
	
	@After
	public void tearDown() {

	}
	
	@Test
	public void testGcdA() throws Exception {
		assertEquals(5, GreatestCommonDivisor.gcd(5, 15));
	}
	
	@Test
	public void testGcdB() throws Exception {
		assertEquals(11, GreatestCommonDivisor.gcd(99, 88));
	}
	
	@Test
	public void testGcdC() throws Exception {
		assertEquals(9, GreatestCommonDivisor.gcd(3456, 1233));
	}
	
	@Test
	public void testGcdRecurA() throws Exception {
		assertEquals(5, GreatestCommonDivisor.gcdRecursive(5, 15));
	}
	
	@Test
	public void testGcdRecurB() throws Exception {
		assertEquals(11, GreatestCommonDivisor.gcdRecursive(99, 88));
	}
	
	@Test
	public void testGcdRecurC() throws Exception {
		assertEquals(9, GreatestCommonDivisor.gcdRecursive(3456, 1233));
	}
	
	
	

}