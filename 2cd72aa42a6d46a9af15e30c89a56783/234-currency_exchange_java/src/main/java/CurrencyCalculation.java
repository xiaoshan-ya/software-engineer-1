import java.util.Scanner;

public class CurrencyCalculation {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.println("How many euros are you exchanging?");
		double euro = scan.nextDouble();

		System.out.println("What is the exchange rate?");
		double rate = scan.nextDouble();

		double dollar = rate * euro / 100;

		System.out.print(String.format("%.2f",euro) + " euros at an exchange rate of " + String.format("%.2f",rate));
		System.out.print(" is ");
		System.out.print(String.format("%.2f",dollar) + " U.S. dollars.");

	}

}
