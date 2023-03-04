import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class ResponseTimeCalculation {

	public static void main(String[] args){

		String inputString = "";
		int max = 0, min = 99999999, all = 0,num;
		double standardDeviation = 0;
		ArrayList<Integer> myList = new ArrayList<>();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		do{
			System.out.println("Enter a Number:");
			try{
				//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				inputString = br.readLine();

			}catch (IOException e){
				e.printStackTrace();
			}

			if (!inputString.equals("done")){
				num = Integer.parseInt(inputString);
				myList.add(num);
				all += num;

				if (num > max)
					max = num;
				if(num < min)
					min = num;
			}
		}while(!inputString.equals("done"));

		double average = all / (float)myList.size();

		String words = "Numbers:";
		for(int i = 0; i < myList.size(); i++){
			standardDeviation += (myList.get(i) - average) * (myList.get(i) - average) / (double)myList.size();
			words += myList.get(i).toString() + ",";
		}
		words = words.substring(0,words.length() - 1);
		System.out.println(words);

		standardDeviation = Math.sqrt(standardDeviation);


		System.out.println("The average is " + String.format("%.2f",average) + ".");
		System.out.println("The minimum is " + min + ".");
		System.out.println("The maximum is " + max + ".");
		System.out.println("The standard deviation is " + String.format("%.2f",standardDeviation) + ".");
	}
	
}
