import static org.junit.Assert.*;

import org.junit.Test;

public class CircleComputationTest {

	@Test
	public void testArea() {
		CircleComputation circleComputation=new CircleComputation();
		assertEquals(1.2*1.2*Math.PI,circleComputation.area(1.2),0.0001);
	}

	@Test
	public void testPerimeter() {
		CircleComputation circleComputation=new CircleComputation();
		assertEquals(1.2*2*Math.PI,circleComputation.perimeter(1.2),0.00000000001);
	}

}
