
import static org.junit.Assert.*;

import org.junit.Test;

public class SingleCharacterIITest {

	@Test
	public void testSingleA() {
		assertEquals('c', SingleCharacterII.singleNumber(new char[]{'a','b','c','a','b'}));
	}
	
	@Test
	public void testSingleB() {
		assertEquals('a', SingleCharacterII.singleNumber(new char[]{'a'}));
	}
	
	@Test
	public void testSingleC() {
		assertEquals('e', SingleCharacterII.singleNumber(new char[]{'a','b','c','d','e','d','c','b','a'}));
	}
	
	@Test
	public void testNull() {
		assertEquals('\0', SingleCharacterII.singleNumber(null));
	}
	
	@Test
	public void testEmptyArray() {
		assertEquals('\0', SingleCharacterII.singleNumber(new char[]{}));
	}
	
	
}
