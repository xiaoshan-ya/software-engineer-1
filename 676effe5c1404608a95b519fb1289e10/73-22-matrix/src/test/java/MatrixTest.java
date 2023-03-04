
import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class MatrixTest {

	@Test
	public void testHaveSameDimensionIntArrayArrayIntArrayArray() {
		int[][]a={{2,3,4},{3,4,5}};
		int[][]b={{2,3,4},{3,4,5}};
		int[][]c={{2,3,42},{3,4,5},{3,2}};		
		
		assertEquals(true,Matrix.haveSameDimension(a, b));
		assertEquals(false,Matrix.haveSameDimension(a, c));
	}

	@Test
	public void testHaveSameDimensionDoubleArrayArrayDoubleArrayArray() {
		double[][]a={{2,3,4},{3,4,5}};
		double[][]b={{2,3,4},{3,4,5}};
		double[][]c={{2,3,42},{3,4,5},{3,2}};
		
		assertEquals(true,Matrix.haveSameDimension(a, b));
		assertEquals(false,Matrix.haveSameDimension(a, c));
	}

	@Test
	public void testAddIntArrayArrayIntArrayArray() {
		int[][]a={{2,3,4},{3,4,5}};
		int[][]b={{2,3,4},{3,4,5}};
		int[][]c=Matrix.add(a, b);
		int[][]d={{4,6,8},{6,8,10}};
		
		assertEquals(true,equals(c,d));
		
		assertEquals(false,equals(a,d));
		
	}

	@Test
	public void testAddDoubleArrayArrayDoubleArrayArray() {
		double[][]a={{2,3,4},{3,4,5}};
		double[][]b={{2,3,4},{3,4,5}};
		double[][]c=Matrix.add(a, b);
		double[][]d={{4,6,8},{6,8,10}};
		
		assertEquals(true,equals(c,d));		
		assertEquals(false,equals(a,d));
	}

	  
	public static boolean equals(int[][]a,int[][]b){
		if (a==b)
			return true;
	    if (a==null || b==null)
	        return false;

	    int lengthOfa = a.length;
	    int lengthOfb = b.length;
	        
	    if (lengthOfa!=lengthOfb)
	       return false;

	    for (int i=0; i<lengthOfa; i++) {
	       if(!Arrays.equals(a[i], b[i]))
	    	   return false;
	    }

	   return true;        
	}
	
	public static boolean equals(double[][]a,double[][]b){
		if (a==b)
            return true;
        if (a==null || b==null)
            return false;

        int lengthOfa = a.length;
        int lengthOfb = b.length;
        
        if (lengthOfa!=lengthOfb)
            return false;

        for (int i=0; i<lengthOfa; i++) {
            if(!Arrays.equals(a[i], b[i]))
            	return false;
        }

        return true;        
	}
	
	
}
