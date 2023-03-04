
public class DetectCaptial {

	public static boolean detectCapitalUse(String word) {
		//如果是空字符串
		if (word.length() == 0){
			return true;
		}
		else{
			//如果全是小写的情况
			if (Character.isLowerCase(word.charAt(0))){
				for (int i = 1; i < word.length(); i++){
					if (!Character.isLowerCase(word.charAt(i))){ return false; }
				}
			}
			else{
				//只有首字母大写的情况
				if (Character.isLowerCase(word.charAt(1))){
					for (int i = 2; i < word.length(); i++){
						if (!Character.isLowerCase(word.charAt(i))){ return false; }
					}
				}
				//全是大写的情况
				else{
					for (int i = 2; i < word.length(); i++){
						if (!Character.isUpperCase(word.charAt(i))){ return false; }
					}
				}
			}
			return true;
		}
    }
	   
}