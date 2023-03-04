import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class GradesHistogram {
	/**
	 * 编写该方法对文件进行处理，并打印直方图，可添加新的方法
	 * @param fileName 处理的文件名
	 */
	public static void histogram(String fileName){
		String line;
		String[] numbers = new String[0];
		String toString = "";
		int flag = 0;
		try(BufferedReader br = new BufferedReader(new FileReader(new File(fileName)))){
			int i = 0;
			while (br.readLine() != null){
				//numbers = new String[Integer.parseInt(line = br.readLine())];
				line = br.readLine();
				numbers = (line).split(" ");
				if (line.contains("100")){ flag = 1; }
			}
		}catch (Exception e){
			e.printStackTrace();
		}

		for (int i = 0; i < 90; i += 10){
			if (i == 0){
				toString += " 0 -  9:" + countNumber(numbers, 0) + System.lineSeparator();
				continue;
			}
			toString += i + " - " + (i + 9) + ":" + countNumber(numbers, i) + System.lineSeparator();
		}
		String lastString = "";
		lastString = countNumber(numbers, 90);
		if (flag == 1){
			lastString += "*";
		}
		toString += "90 -100:" + lastString;
		System.out.print(toString);
	}

	public static String countNumber(String[] numbers, int begin){
		String result = "";
		for (String num: numbers){
			int number = Integer.parseInt(num);
			if (number >= begin && number <= begin + 9){
				result += "*";
			}
		}
		return result;
	}

}
