
import static org.junit.Assert.*;

import org.junit.Test;

public class DetectCaptialTest {

	@Test
	public void testAllCaptial() {
		assertEquals(true, DetectCaptial.detectCapitalUse("NJU"));
	}
	
	@Test
	public void testTwoCaptial() {
		assertEquals(true, DetectCaptial.detectCapitalUse("NA"));
	}
	
	@Test
	public void testAllNotCaptial() {
		assertEquals(true, DetectCaptial.detectCapitalUse("university"));
	}
	
	@Test
	public void testFirstCaptial() {
		assertEquals(true, DetectCaptial.detectCapitalUse("Git"));
	}
	
	@Test
	public void testFirstTwoCaptial() {
		assertEquals(false, DetectCaptial.detectCapitalUse("TEacher"));
	}
	
	@Test
	public void testNotValid() {
		assertEquals(false, DetectCaptial.detectCapitalUse("softWare"));
	}
	
	@Test
	public void testEmptyString() {
		assertEquals(true, DetectCaptial.detectCapitalUse(""));
	}

}
