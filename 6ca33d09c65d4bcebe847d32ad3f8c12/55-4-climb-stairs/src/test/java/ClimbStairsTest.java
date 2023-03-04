import static org.junit.Assert.assertEquals;

import org.junit.Test;



public class ClimbStairsTest {



	@Test
	public void testSingleA() {

		assertEquals(3, ClimbStairs.climbStairs(3));

	}

	

	@Test
	public void testSingleB() {

		assertEquals(8, ClimbStairs.climbStairs(5));

	}

	

	@Test
	public void testSingleC() {

		assertEquals(13, ClimbStairs.climbStairs(6));

	}


	@Test
	public void testSingleD() {

		assertEquals(514229, ClimbStairs.climbStairs(28));

	}

	@Test
	public void testSingleE() {

		assertEquals(377, ClimbStairs.climbStairs(13));

	}
	


	

	

}