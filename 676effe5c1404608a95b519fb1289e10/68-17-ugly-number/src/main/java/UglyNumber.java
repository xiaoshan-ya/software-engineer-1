import java.util.ArrayList;

public class UglyNumber {

	public static boolean isUgly(int num) {
		if (num == 1){
			return true;
		}
		for (int i = 2; i < num; i++){
			if (num % i == 0 && isPrime(i)){
				if (i != 2 && i != 3 && i != 5){
					return false;
				}
			}
		}
		return true;
    }

    public static boolean isPrime(int i){
		for (int j = 2; j < i; j++){
			if (i % j == 0){
				return false;
			}
		}
		return true;
	}

}
