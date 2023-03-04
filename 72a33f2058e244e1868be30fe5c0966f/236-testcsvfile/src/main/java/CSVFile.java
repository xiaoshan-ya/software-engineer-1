import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class CSVFile {

	public static void main(String[] args) {
		String filePath = CSVFile.class.getClassLoader().getResource("data.txt").getPath();
		printCSVFile(filePath);
		//本地测试用./target/classes/data.txt
	}
	
	public static void printCSVFile(String filePath){
		System.out.println("Last    Fisrt    Salary");
		try(BufferedReader reader = new BufferedReader(new FileReader(new File(filePath)))){
			String line = null;
            while((line = reader.readLine()) !=  null){
            	//line = line.substring(0,line.length()-1);
				String[] stringList = line.split(",");

				String string = stringList[0] + "    " + stringList[1] + "    " + stringList[2];

				System.out.println(string);
			}
		}catch (Exception ex){
			ex.printStackTrace();
		}
	}
	

}
