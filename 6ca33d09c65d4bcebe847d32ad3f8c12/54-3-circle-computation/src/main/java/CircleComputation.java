/*Exercise CircleComputation (User Input): Write a program called CircleComputation,
 *  which prompts user for a radius (of double) and compute the area and perimeter 
 *  of a circle. 
Hints: π is kept in a constant called Math.PI.
*/

public class CircleComputation{
	
	/**
	 * 计算圆面积
	 * @param radius
	 * @return 面积大小
	 */
	public double area(double radius){
		double result = 0;
		double pi = Math.PI;
		result = pi * radius *radius;
		return result;
	}
	
	/**
	 * 计算圆周长
	 * @param radius
	 * @return 圆周长
	 */
	public double perimeter(double radius){
		double result = 0;
		double pi = Math.PI;
		result = 2 * pi * radius;
		return result;
	}
}