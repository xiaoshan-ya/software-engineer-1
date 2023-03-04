
public class Digits {
	public String reverseInt(int input){
		String forward = input + "";
		String reverse = "";
		String[] words = forward.split("");
		for (int i = words.length - 1; i >= 0; i--){
			reverse += words[i];
		}
		return reverse;
	}
}
