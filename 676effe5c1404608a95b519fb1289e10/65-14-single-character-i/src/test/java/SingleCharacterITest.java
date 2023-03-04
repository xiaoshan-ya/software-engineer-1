
import static org.junit.Assert.*;

import org.junit.Test;

public class SingleCharacterITest {

	@Test
	public void testSingleA() {
		assertEquals('c', SingleCharacterI.singleNumber(new char[]{'a','b','c','a','b'}));
	}
	
	@Test
	public void testSingleB() {
		assertEquals('a', SingleCharacterI.singleNumber(new char[]{'a'}));
	}
	
	@Test
	public void testSingleC() {
		assertEquals('e', SingleCharacterI.singleNumber(new char[]{'a','b','c','d','e','d','c','b','a'}));
	}
	
	@Test
	public void testNull() {
		assertEquals('\0', SingleCharacterI.singleNumber(null));
	}
	
	@Test
	public void testEmptyArray() {
		assertEquals('\0', SingleCharacterI.singleNumber(new char[]{}));
	}
	
	
}
