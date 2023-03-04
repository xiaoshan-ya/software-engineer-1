
public class HammingDistance {

	public static int hammingDistance(int x, int y){
		String X = Integer.toBinaryString(x);
		String Y = Integer.toBinaryString(y);
		int distance = 0;

		String my_0 = "";
		if (X.length() > Y.length()){
			for (int i = 0; i < X.length() - Y.length(); i++){
				my_0 += "0";
			}
			Y = my_0 + Y;
		}
		else{
			for (int i = 0; i < Y.length() - X.length(); i++){
				my_0 += 0;
			}
			X = my_0 + X;
		}

		for (int i = 0; i < X.length(); i++){
			if (X.charAt(i) != Y.charAt(i)){ distance++; }
		}

		return distance;
	}
}