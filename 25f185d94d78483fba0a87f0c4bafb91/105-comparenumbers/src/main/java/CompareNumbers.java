import java.util.Scanner;

public class CompareNumbers {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.println("Enter the first number:");
		int firstNum = scan.nextInt();

		System.out.println("Enter the second number:");
		int secondNum = scan.nextInt();

		System.out.println("Enter the third number:");
		int thirdNum = scan.nextInt();

		if (firstNum == secondNum | secondNum == thirdNum | firstNum == thirdNum){
			System.out.println("There are same numbers.");
		}
		else{
			int max1 = Math.max(firstNum, secondNum);
			int max2 = Math.max(max1, thirdNum);

			System.out.println("The largest number is " + max2 + ".");
		}
	}

}
