
import static org.junit.Assert.*;

import org.junit.Test;

public class HammingDistanceTest {

	@Test
	public void testZeroDistance() {
		int actualDistance = HammingDistance.hammingDistance(2, 2);
		assertEquals(0, actualDistance);
	}
	
	@Test
	public void testPositive() {
		int actualDistance = HammingDistance.hammingDistance(2, 4);
		assertEquals(2, actualDistance);
	}
	
	@Test
	public void testNegative() {
		int actualDistance = HammingDistance.hammingDistance(-2, -4);
		assertEquals(1, actualDistance);
	}
	
	@Test
	public void testPostiveNegative() {
		int actualDistance = HammingDistance.hammingDistance(2, -4);
		assertEquals(31, actualDistance);
	}
	
	@Test
	public void testZero() {
		int actualDistance = HammingDistance.hammingDistance(0, 0);
		assertEquals(0, actualDistance);
	}

}
