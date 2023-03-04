
public class Matrix {
	   
	   /**
	    * 判断m1和m2是否维度相同
	    * @param m1
	    * @param m2
	    * @return 判断结果
	    */
	   public static boolean haveSameDimension(int[][] m1, int[][] m2){
	   		if (m1.length == m2.length && m1[0].length == m2[0].length){
	   			return true;
			}
	   		return false;
	   }
	   
	   /**
	    * 判断m1和m2是否维度相同
	    * @param m1
	    * @param m2
	    * @return 判断结果
	    */
	   public static boolean haveSameDimension(double[][] m1, double[][] m2){
		   if (m1.length == m2.length && m1[0].length == m2[0].length){
			   return true;
		   }
		   return false;
	   }
	   
	   /**
	    * 将二维数组相加
	    * @param m1
	    * @param m2
	    * @return 二维数组
	    */
	   public static int[][] add(int[][] m1, int[][] m2){
		   int[][] myMatrix = new int[m1.length][m1[0].length];
		   for (int i = 0; i < m1.length; i++){
		   		for (int j = 0; j < m1[0].length; j++){
		   			myMatrix[i][j] = m1[i][j] + m2[i][j];
				}
		   }
		   return myMatrix;
	   }
	   
	   /**
	    * 将二维数组相加
	    * @param m1
	    * @param m2
	    * @return 二维数组
	    */
	   public static double[][] add(double[][] m1, double[][] m2){
		   double[][] myMatrix = new double[m1.length][m1[0].length];
		   for (int i = 0; i < m1.length; i++){
			   for (int j = 0; j < m1[0].length; j++){
				   myMatrix[i][j] = m1[i][j] + m2[i][j];
			   }
		   }
		   return myMatrix;
	   }
	   
	}