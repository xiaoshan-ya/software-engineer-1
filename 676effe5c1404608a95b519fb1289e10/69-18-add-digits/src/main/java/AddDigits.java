
public class AddDigits {

	 public static int addDigits(int num) {
	 	if (num / 10 == 0){
	 		return num;
		}
	 	else{
	 		int newNum = 0;
	 		String[] words = (num + "").split("");
	 		for (String word: words){
	 			newNum += Integer.parseInt(word);
			}
	 		return addDigits(newNum);
		}
	 }
}
