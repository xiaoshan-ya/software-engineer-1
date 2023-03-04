
import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FibonacciTest {
	Fibonacci fib;
	@Before
	public void setUp() throws Exception {
		fib = new Fibonacci();
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testFibonacci1(){
		assertEquals(0,fib.FibonacciN(0));
	}
	
	@Test
	public void testFibonacci2(){
		assertEquals(1,fib.FibonacciN(1));
	}
	
	@Test
	public void testFibonacci3(){
		assertEquals(1,fib.FibonacciN(2));
	}
	
	@Test
	public void testFibonacci4(){
		assertEquals(3,fib.FibonacciN(4));
	}
	
	@Test
	public void testFibonacci5(){
		assertEquals(13,fib.FibonacciN(7));
	}
	
	@Test
	public void testFibonacci6(){
		assertEquals(34,fib.FibonacciN(9));
	}
	
	@Test
	public void testFibonacci7(){
		assertEquals(55,fib.FibonacciN(10));
	}
	
	@Test
	public void testFibonacci8(){
		assertEquals(144,fib.FibonacciN(12));
	}
	
	@Test
	public void testFibonacci9(){
		assertEquals(377,fib.FibonacciN(14));
	}
	
	@Test
	public void testFibonacci10(){
		assertEquals(2584,fib.FibonacciN(18));
	}

}
