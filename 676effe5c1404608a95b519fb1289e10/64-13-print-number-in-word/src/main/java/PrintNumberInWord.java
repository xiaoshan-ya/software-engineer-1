
public class PrintNumberInWord {
	public String Number2String(int input){
		if (input >= 0){ return input + ""; }
		else{
			input = Math.abs(input);
			return "-" + input;
		}
	}
}
