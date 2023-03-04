
public class Bin2Dec {

	public String bin2dec(String input){
		String[] nums = input.split("");
		int cnt = nums.length - 1;
		int result = 0;
		for (String num: nums){
			int number = Integer.parseInt(num);
			result += number * Math.pow(2, cnt);
			cnt -= 1;
		}
		String bin2dec = result + "";
		return bin2dec;
	}

}
