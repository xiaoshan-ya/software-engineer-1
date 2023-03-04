import java.util.Scanner;

public class HeartRateCalculation {

	public static void main(String[] args) {
		System.out.println("RestingHR:");
		Scanner scan = new Scanner(System.in);

		int restingHR = scan.nextInt();

		System.out.println("Age:");

		int age = scan.nextInt();

		System.out.println("Intensity|TargetHeartRate");
		System.out.println("---------|---------------");

		for(int Intensity = 55; Intensity < 100; Intensity += 5){

			double TargetHeartRate = (((220 - age) - restingHR) * Intensity / 100.0) + restingHR;


			System.out.print(String.format("%d",Intensity) + "%|");
			System.out.println(String.format("%.0f",TargetHeartRate) + "bpm");
		}
	}
}
