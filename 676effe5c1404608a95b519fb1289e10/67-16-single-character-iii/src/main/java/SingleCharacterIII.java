
public class SingleCharacterIII {

	public static char singleNumber(char[] characters) {
		if (characters != null && characters.length > 0){
			int result = characters[0];
			for (int i = 1; i < characters.length; i++){
				result = result ^ characters[i];
			}
			return (char) result;
		}
		return '\0';

    }
	   
}