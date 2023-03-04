
import static org.junit.Assert.*;

import org.junit.Test;

public class BinarySearchTest {

	@Test
	public void testSearchFirst() {
		assertEquals(0, BinarySearch.search(new int[]{1,2,3,4,5}, 1));
	}
	
	@Test
	public void testSearchLast() {
		assertEquals(4, BinarySearch.search(new int[]{1,2,3,4,5}, 5));
	}
	
	@Test
	public void testSearchNotExists() {
		assertEquals(-1, BinarySearch.search(new int[]{1,2,3,4,5}, 6));
	}
	
	@Test
	public void testSearchNormal() {
		assertEquals(2, BinarySearch.search(new int[]{1,2,3,4,5}, 3));
	}
	
	@Test
	public void testSearchOne() {
		assertEquals(0, BinarySearch.search(new int[]{1}, 1));
	}
}
