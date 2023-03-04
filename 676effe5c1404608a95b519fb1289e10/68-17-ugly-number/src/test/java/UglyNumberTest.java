import static org.junit.Assert.assertEquals;

import org.junit.Test;



public class UglyNumberTest {



	@Test
	public void testSingleA() {

		assertEquals(true, UglyNumber.isUgly(8));

	}



	@Test
	public void testSingleB() {

		assertEquals(false, UglyNumber.isUgly(14));

	}



	@Test
	public void testSingleC() {

		assertEquals(true, UglyNumber.isUgly(15));

	}



	@Test
	public void testSingleD() {

		assertEquals(true, UglyNumber.isUgly(180));

	}


	@Test
	public void testSingleE() {

		assertEquals(false, UglyNumber.isUgly(210));

	}





}
