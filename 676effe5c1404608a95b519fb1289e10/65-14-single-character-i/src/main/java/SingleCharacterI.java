import java.util.Arrays;

public class SingleCharacterI {

	public static char singleNumber(char[] characters) {
		if (characters != null && characters.length != 0){
			for (int i = 0; i < characters.length; i++){
				int flag = 0;
				for (int j = 0; j < characters.length; j++){
					if (characters[i] == characters[j] && i != j){
						flag = 1;
						break;
					}
				}
				if (flag == 0){ return characters[i]; }
			}
		}
		return '\0';
    }
	   
}