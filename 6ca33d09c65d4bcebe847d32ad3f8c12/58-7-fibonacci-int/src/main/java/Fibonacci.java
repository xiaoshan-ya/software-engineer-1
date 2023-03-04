
public class Fibonacci {
	public int FibonacciN(int input){
		if (input == 0){
			return 0;
		}
		else if (input == 1){
			return 1;
		}
		else{
			return FibonacciN(input - 1) + FibonacciN(input - 2);
		}
	}
}
