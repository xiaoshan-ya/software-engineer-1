import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class PhoneKeyPadTest {

	@Before
	public void setUp() {

	}
	
	@After
	public void tearDown() {

	}
	
	@Test
	public void testNoInput() throws Exception {
		check("","");
	}
	
	@Test
	public void testNullInput() throws Exception {
		check(null,"");
	}
	
	@Test
	public void testOneLetter() throws Exception {
		check("a","2");
	}
	
	@Test
	public void testLowerCondition() throws Exception {
		check("abcdegj","2,2,2,3,3,4,5");
	}
	
	@Test
	public void testUpperCondition() throws Exception {
		check("ABCDEGJ","2,2,2,3,3,4,5");
	}
	
	@Test
	public void testNormalCondition() throws Exception {
		check("AbcDEGj","2,2,2,3,3,4,5");
	}
	
	private void check(String input,  String expected){
		String actual=PhoneKeyPad.convert(input);
		assertEquals(actual, expected);
	}

}