import java.util.HashMap;
import java.util.Map;

public class SingleCharacterII {

	public static char singleNumber(char[] characters) {
		if (characters != null && characters.length > 0){
			Map<String, Integer> map = new HashMap<>();
			for (char character: characters){
				String string = String.valueOf(character);
				if (!map.containsKey(string)){
					map.put(string, 1);
				}
				else{
					map.put(string, 2);
				}
			}

			for (Map.Entry<String, Integer> entry: map.entrySet()){
				if (entry.getValue() == 1){
					return entry.getKey().charAt(0);
				}
			}
		}
		return '\0';
    }
	   
}