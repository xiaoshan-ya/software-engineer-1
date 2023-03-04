
public class BinarySearch {

	public static int search(int[] data, int target) {
		for (int result = 0; result < data.length; result++){
			if (data[result] == target){ return result; }
		}
		return -1;
    }
	   
}