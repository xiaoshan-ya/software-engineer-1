
public class ArrayToInteger {

	public static int getInteger(int[] numbers) {
		if (numbers.length == 1){
			return numbers[0];
		}
		else{
			String num = "";
			int cnt = 0;
			for (int i = 0; i < numbers.length; i++){
				num += numbers[i];
			}
			for (int i = 0; i < numbers.length; i++){
				if (numbers[i] == 0){ cnt++; }
			}
			if (Math.pow(10, numbers.length - cnt) > Integer.MAX_VALUE){ return Integer.MAX_VALUE; }
			else {
				return Integer.parseInt(num);
			}
		}

    }
	   
}