import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PrintNumberInWordTest {
	PrintNumberInWord numToStr;
	@Before
	public void setUp() throws Exception {
		numToStr = new PrintNumberInWord();
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testPrintNumberTnWord1(){
		assertEquals("3435",numToStr.Number2String(3435));
	}
	
	@Test
	public void testPrintNumberTnWord2(){
		assertEquals("0",numToStr.Number2String(0));
	}
	
	@Test
	public void testPrintNumberTnWord3(){
		assertEquals("67547",numToStr.Number2String(67547));
	}
	
	@Test
	public void testPrintNumberTnWord4(){
		assertEquals("-2334",numToStr.Number2String(-2334));
	}
	
	@Test
	public void testPrintNumberTnWord5(){
		assertEquals("9999",numToStr.Number2String(9999));
	}
	
	@Test
	public void testPrintNumberTnWord6(){
		assertEquals("1998",numToStr.Number2String(1998));
	}
	
	@Test
	public void testPrintNumberTnWord7(){
		assertEquals("100",numToStr.Number2String(100));
	}
	
	@Test
	public void testPrintNumberTnWord8(){
		assertEquals("4765",numToStr.Number2String(4765));
	}
	
	@Test
	public void testPrintNumberTnWord9(){
		assertEquals("2525665",numToStr.Number2String(2525665));
	}
	
	@Test
	public void testPrintNumberTnWord10(){
		assertEquals("-34536",numToStr.Number2String(-34536));
	}
}
