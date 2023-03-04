
public class GreatestCommonDivisor {
	public static int gcd(int a, int b) {
		if (b == 0) { return a; }
		while (a % b != 0){
			int temp = a;
			a = b;
			b = temp % b;
		}
		return b;
	}
	
	public static int gcdRecursive(int a,int b){
		if (b == 0){
			return a;
		}
		else{
			return gcdRecursive(b, a % b);
		}
		
		
	}
}
