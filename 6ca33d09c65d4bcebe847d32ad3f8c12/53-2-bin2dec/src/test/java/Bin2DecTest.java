
import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
public class Bin2DecTest {
	
	Bin2Dec b2d;
	
	@Before
	public void setUp() throws Exception {
		b2d = new Bin2Dec();
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testBin2Dec1(){
		assertEquals("1",b2d.bin2dec("1"));	
	}
	
	@Test
	public void testBin2Dec2(){
		assertEquals("10",b2d.bin2dec("1010"));	
	}

	@Test
	public void testBin2Dec3(){
		assertEquals("15",b2d.bin2dec("1111"));	
	}

	@Test
	public void testBin2Dec4(){
		assertEquals("24",b2d.bin2dec("011000"));	
	}

	@Test
	public void testBin2Dec5(){
		assertEquals("25",b2d.bin2dec("011001"));	
	}
	
	@Test
	public void testBin2Dec6(){
		assertEquals("152",b2d.bin2dec("10011000"));	
	}
	
	@Test
	public void testBin2Dec7(){
		assertEquals("1624",b2d.bin2dec("11001011000"));	
	}

	@Test
	public void testBin2Dec8(){
		assertEquals("49",b2d.bin2dec("0110001"));	
	}

	@Test
	public void testBin2Dec9(){
		assertEquals("31",b2d.bin2dec("011111"));	
	}
	
	@Test
	public void testBin2Dec10(){
		assertEquals("56",b2d.bin2dec("111000"));	
	}

}
