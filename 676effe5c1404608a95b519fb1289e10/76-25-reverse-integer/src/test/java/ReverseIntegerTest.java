import static org.junit.Assert.assertEquals;

import org.junit.Test;



public class ReverseIntegerTest {



	@Test

	public void testSingleA() {

		assertEquals(321, ReverseInteger.reverseInteger(123));

	}

	

	@Test

	public void testSingleB() {

		assertEquals(-321, ReverseInteger.reverseInteger(-123));

	}

	


	

	

}