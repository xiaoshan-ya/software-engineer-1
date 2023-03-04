
import static org.junit.Assert.*;

import org.junit.Test;

public class NumberComplementTest {

	@Test
	public void testRandomPositive() {
		int actualComplement = NumberComplement.findComplement(5);
		assertEquals(2, actualComplement);
	}
	
	@Test
	public void testRandomNegative() {
		int actualComplement = NumberComplement.findComplement(-10);
		assertEquals(9, actualComplement);
	}
	
	@Test
	public void testOne() {
		int actualComplement = NumberComplement.findComplement(1);
		assertEquals(0, actualComplement);
	}
	
	@Test
	public void testMax() {
		int actualComplement = NumberComplement.findComplement(2147483647);
		assertEquals(0, actualComplement);
	}
	
	@Test
	public void testMin() {
		int actualDistance = NumberComplement.findComplement(-2147483648);
		assertEquals(2147483647, actualDistance);
	}

}
