
public class PhoneKeyPad{

	public static String convert(String s){
		if (s != null && !s.equals("")){
			String result = "";
			String[] words = s.split("");
			for (String word: words){
				switch (word){
					case "A":
					case "B":
					case "C":
					case "a":
					case "b":
					case "c":
						result += "2,";
						break;
					case "D":
					case "E":
					case "F":
					case "d":
					case "e":
					case "f":
						result += "3,";
						break;
					case "G":
					case "H":
					case "I":
					case "g":
					case "h":
					case "i":
						result += "4,";
						break;
					case "J":
					case "K":
					case "L":
					case "j":
					case "k":
					case "l":
						result += "5,";
						break;
					case "M":
					case "N":
					case "O":
					case "m":
					case "n":
					case "o":
						result += "6,";
						break;
					case "P":
					case "Q":
					case "R":
					case "S":
					case "p":
					case "q":
					case "r":
					case "s":
						result += "7,";
						break;
					case "T":
					case "U":
					case "V":
					case "t":
					case "u":
					case "v":
						result += "8,";
						break;
					default:
						result += "9,";

				}
			}
			return result.substring(0, result.length() - 1);

		}
		return "";
	}
}