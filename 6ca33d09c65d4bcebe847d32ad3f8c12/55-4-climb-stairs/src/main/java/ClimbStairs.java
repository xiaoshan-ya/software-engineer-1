
public class ClimbStairs {

	public static int climbStairs(int n) {
		int cnt = 0;
		cnt = myFuncation(n);
		return cnt;
	}

	public static int myFuncation(int n){
		if (n == 0){
			return 0;
		}
		else if (n == 1){
			return 1;
		}
		else if (n == 2){
			return 2;
		}
		else{
			return myFuncation(n - 1) + myFuncation(n - 2);
		}
	}


}
