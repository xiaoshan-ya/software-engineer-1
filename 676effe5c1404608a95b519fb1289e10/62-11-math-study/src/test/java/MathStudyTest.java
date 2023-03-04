
import static org.junit.Assert.*;

import org.junit.Test;

public class MathStudyTest {

	@Test
	public void testAbs() {
		assertEquals(1,MathStudy.abs(-1),0.000001);
		assertEquals(1.2,MathStudy.abs(-1.2),0.000001);
	}

}
