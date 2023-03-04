import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 矩阵类，实现矩阵的加法，矩阵乘法，点乘以及转置方法
 * 其中加法和点乘方法需要有两种实现方式
 * 1.传入一个MyMatrix对象进行2个矩阵的操作
 * 2.从控制台（console）读入一个矩阵数据，再进行操作
 * 所有的数据均为int型
 * 输入数据均默认为正确数据，不需要对输入数据进行校验
 * @author Ray Liu & Qin Liu
 *
 */
public class MyMatrix {
	private int[][] data;
	
	/**
	 * 构造函数，参数为2维int数组
	 * a[i][j]是矩阵中的第i+1行，第j+1列数据
	 * @param a
	 */
	public MyMatrix(int[][] a){
		this.data = a;
	}

	public int[][] getData() {
		return data;
	}

	/**
	 * 实现矩阵加法，返回一个新的矩阵
	 * @param B
	 * @return
	 */
	public MyMatrix plus(MyMatrix B){
		int hang = data.length;
		int lie = data[0].length;

		int[][] c = new int[hang][];

		for (int i = 0; i < hang; i++){

			c[i] = new int[lie];

			for (int j = 0; j < lie; j++){
				c[i][j] = data[i][j] + B.data[i][j];
			}
		}
		return new MyMatrix(c);
	}

	
	/**
	 * 实现矩阵乘法，返回一个新的矩阵
	 * @param B
	 * @return
	 */
	public MyMatrix times(MyMatrix B){
		int hang = data.length;
		int lie = B.data[0].length;

		int[][] c = new int[hang][lie];

		for (int i = 0; i < hang; i++){
			for (int j = 0; j < lie; j++){

				for (int y = 0; y < hang; y++){
					c[i][j] += data[i][y] * B.data[y][j];
				}
			}
		}
		MyMatrix d = new MyMatrix(c);

		return d;
	}
	
	/**
	 * 实现矩阵的点乘，返回一个新的矩阵
	 * @param b
	 * @return
	 */
	public MyMatrix times(int b){
		int hang = data.length;
		int lie = data[0].length;

		int[][] c = new int[hang][lie];

		for (int i = 0; i < hang; i++){
			for (int j = 0; j <lie; j++){
				c[i][j] = 1;
				c[i][j] *= b;
			}
		}
		MyMatrix d = new MyMatrix(c);

		return d;
	}
	
	/**
	 * 实现矩阵的转置，返回一个新的矩阵
	 * @return
	 */
	public MyMatrix transpose(){

		int hang = data[0].length;
		int lie = data.length;

		int[][] c = new int[hang][lie];

		for (int i = 0; i < hang; i++){
			for (int j = 0; j < lie; j++) {
				c[i][j] = data[j][i];
			}
		}
		MyMatrix d = new MyMatrix(c);
		return d;
	}
	
	/**
	 * 从控制台读入矩阵数据，进行矩阵加法，读入数据格式如下：
	 * m n
	 * m * n 的数据方阵，以空格隔开
	 * example:
	 * 4 3
	 * 1 2 3 
	 * 1 2 3
	 * 1 2 3
	 * 1 2 3
	 * 返回一个新的矩阵
	 * @return
	 */
	public MyMatrix plusFromConsole(){
		String input = "";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try{

			input = br.readLine();

		}catch(IOException e){
			e.printStackTrace();
		}

		String [] nums = input.split(" ");
		int hang = Integer.parseInt(nums[0]);
		int lie = Integer.parseInt((nums[1]));
		int[][] c = new int[hang][lie];

		for (int i = 0; i < hang; i++){

			try{
				input = br.readLine();
			}catch(IOException e){
				e.printStackTrace();
			}

			nums = input.split(" ");
			for (int j = 0; j < lie; j++){
				c[i][j] = Integer.parseInt(nums[j]);
			}
		}

		MyMatrix d = plus(new MyMatrix(c));

		return d;
	}
	
	/**
	 * 输入格式同上方法相同
	 * 实现矩阵的乘法
	 * 返回一个新的矩阵
	 * @return
	 */
	public MyMatrix timesFromConsole(){

		String input = "";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try{

			input = br.readLine();

		}catch(IOException e){
			e.printStackTrace();
		}

		String [] nums = input.split(" ");

		if (nums.length != 1){
			int hang = Integer.parseInt(nums[0]);
			int lie = Integer.parseInt((nums[1]));
			int[][] c = new int[hang][lie];

			for (int i = 0; i < hang; i++){

				try{
					input = br.readLine();
				}catch(IOException e){
					e.printStackTrace();
				}

				nums = input.split(" ");
				for (int j = 0; j < lie; j++){
					c[i][j] = Integer.parseInt(nums[j]);
				}
			}

			MyMatrix d = times(new MyMatrix(c));
			return d;
		}
		else{
			int b = Integer.parseInt(nums[0]);
			MyMatrix d = times(b);
			return d;
		}

	}
	
	/**
	 * 打印出该矩阵的数据
	 * 起始一个空行，结束一个空行
	 * 矩阵中每一行数据呈一行，数据间以空格隔开
	 * example：
	 * 
	 * 1 2 3
	 * 1 2 3
	 * 1 2 3
	 * 1 2 3
	 * 
	 */
	public void print(){
		System.out.print("\n");
		int hang = data.length;
		int lie = data[0].length;
		for(int i = 0; i < hang; i++){
			for (int j = 0; j < lie - 1; j ++){
				System.out.print(data[i][j] + " ");
			}
			System.out.println(data[i][lie - 1]);
		}
		System.out.print("\n");
	}
}
