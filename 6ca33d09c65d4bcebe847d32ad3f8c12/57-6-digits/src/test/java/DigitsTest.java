
import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DigitsTest {
	Digits digit ;
	
	@Before
	public void setUp() throws Exception {
		digit = new Digits();
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testDigits1(){
		assertEquals("54321",digit.reverseInt(12345));
	}
	
	@Test
	public void testDigits2(){
		assertEquals("7856551",digit.reverseInt(1556587));
	}
	
	@Test
	public void testDigits3(){
		assertEquals("0001",digit.reverseInt(1000));
	}
	
	@Test
	public void testDigits4(){
		assertEquals("4237766",digit.reverseInt(6677324));
	}
	
	@Test
	public void testDigits5(){
		assertEquals("7487654",digit.reverseInt(4567847));
	}
	
	@Test
	public void testDigits6(){
		assertEquals("5579365",digit.reverseInt(5639755));
	}
	
	@Test
	public void testDigits7(){
		assertEquals("58700004",digit.reverseInt(40000785));
	}
	
	@Test
	public void testDigits8(){
		assertEquals("001564543",digit.reverseInt(345465100));
	}
	
	@Test
	public void testDigits9(){
		assertEquals("01",digit.reverseInt(10));
	}
	
	@Test
	public void testDigits10(){
		assertEquals("1",digit.reverseInt(1));
	}
}
