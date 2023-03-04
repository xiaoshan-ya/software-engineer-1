
public class PowerOfTwo {

	public static boolean isPowerOfTwo(int n) {
		String binary = Integer.toBinaryString(n);
		String[] words = binary.split("");
		if (words[0].equals("1")){
			for (int i = 1; i < words.length; i++){
				if (words[i].equals("1")){
					return false;
				}
			}
			return true;
		}
		return false;
    }
	   
}