import static org.junit.Assert.assertEquals;

import org.junit.Test;



public class AddDigitsTest {



	@Test

	public void testSingleA() {

		assertEquals(2, AddDigits.addDigits(38));

	}

	

	@Test

	public void testSingleB() {

		assertEquals(1, AddDigits.addDigits(100));

	}

	

	@Test

	public void testSingleC() {

		assertEquals(9, AddDigits.addDigits(639));

	}

	


	

	

}