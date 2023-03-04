
public class NumberComplement {

	public static int findComplement(int num) {
		String num_to_binary = Integer.toBinaryString(num);
		String[] list = num_to_binary.split("");
		for (int i = 0; i < num_to_binary.length(); i++){
			if (list[i].equals("1")){
				list[i] = "0";
			}
			else{
				list[i] = "1";
			}
		}

		String transform = "";
		for (int i = 0; i < num_to_binary.length(); i++){
			transform += list[i];
		}

		int transformNum = Integer.parseInt(transform, 2);
		return transformNum;
    }
	   
}