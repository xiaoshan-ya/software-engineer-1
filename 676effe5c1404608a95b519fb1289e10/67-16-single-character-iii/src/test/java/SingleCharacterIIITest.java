
import static org.junit.Assert.*;

import org.junit.Test;

public class SingleCharacterIIITest {

	@Test
	public void testSingleA() {
		assertEquals('c', SingleCharacterIII.singleNumber(new char[]{'a','b','c','a','b'}));
	}
	
	@Test
	public void testSingleB() {
		assertEquals('a', SingleCharacterIII.singleNumber(new char[]{'a'}));
	}
	
	@Test
	public void testSingleC() {
		assertEquals('e', SingleCharacterIII.singleNumber(new char[]{'a','b','c','d','e','d','c','b','a'}));
	}
	
	@Test
	public void testNull() {
		assertEquals('\0', SingleCharacterIII.singleNumber(null));
	}
	
	@Test
	public void testEmptyArray() {
		assertEquals('\0', SingleCharacterIII.singleNumber(new char[]{}));
	}
	
	
}
