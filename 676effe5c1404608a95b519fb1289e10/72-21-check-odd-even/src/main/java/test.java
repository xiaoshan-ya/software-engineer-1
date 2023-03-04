import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test {
    public static void main(String[] args){
        String input = "";
        try{
            System.out.print("please input a number: ");
            System.lineSeparator();
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            input = br.readLine();

        }catch(IOException ex){
            ex.printStackTrace();
        }
        int num = Integer.parseInt(input);
        System.out.println("your input is : " + num);
    }

}
