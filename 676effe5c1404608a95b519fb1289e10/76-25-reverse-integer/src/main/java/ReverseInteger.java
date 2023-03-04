
public class ReverseInteger {
	 public static int reverseInteger(int n) {
	 	 if (n > 0){
	 	 	String num = n + "";
	 	 	String newNum = "";
	 	 	String[] words = num.split("");
	 	 	for (int i = words.length - 1; i >= 0; i--){
	 	 		newNum += words[i];
			}
	 	 	return Integer.parseInt(newNum);
		 }
	 	 else{
	 	 	n = Math.abs(n);
			 String num = n + "";
			 String newNum = "";
			 String[] words = num.split("");
			 for (int i = words.length - 1; i >= 0; i--){
				 newNum += words[i];
			 }
			 return -Integer.parseInt(newNum);
		 }
	    
	 }
}
