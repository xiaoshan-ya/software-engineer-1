package edu.nju;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * 实现矩阵的加法、乘法以及控制台输出
 * 其中加法和乘法需要有两种实现方式
 * 1.传入一个矩阵进行2个矩阵的操作
 * 2.从控制台（console）读入一个矩阵，再进行操作
 * 所有的数据均为int型
 * 输入数据均默认为正确数据，不需要对输入数据进行校验
 * @author Ray Liu & Qin Liu
 */
public class MatrixCalculation {

	/**
	 * 实现矩阵加法，返回一个新的矩阵
	 * @return result matrix = A + B
	 */
	public int[][] plus(int[][] A, int[][] B){
		// TODO
		int hang = A.length;
		int lie = A[0].length;

		int[][] C = new int [hang][];
		for(int i = 0; i < hang; i++){
			C[i] = new int [lie];
			for(int j = 0; j< lie; j++){
				C[i][j] = A[i][j] + B[i][j];
			}
		}

		return C;
	}

	/**
	 * 实现矩阵乘法，返回一个新的矩阵
	 * @return result matrix = A * B
	 */
	public int[][] times(int[][] A, int[][] B){
		// TODO
		int hang = A.length;
		int lie = B[0].length;

		int[][] C = new int[hang][];
		for(int i = 0; i < hang; i++){
			C[i] = new int[lie];
			for(int j = 0; j < lie; j++){
				C[i][j] = 0;

				for(int y = 0; y < A[0].length; y++){
					C[i][j] += A[i][y] * B[y][j];
				}
			}
		}
		return C;
	}

	/**
	 * 从控制台读入矩阵数据，进行矩阵加法，读入数据格式如下：
	 * m n
	 * m * n 的数据方阵，以空格隔开
	 * 连续读入2个矩阵数据
	 * example:
	 * 4 3
	 * 1 2 3
	 * 1 2 3
	 * 1 2 3
	 * 1 2 3
	 * 4 3
	 * 1 2 3
	 * 1 2 3
	 * 1 2 3
	 * 1 2 3
	 * 返回一个新的矩阵
	 */
	public int [][] plusFromConsole(){
		// TODO
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String string = null;

		try{
			string = br.readLine();

		}catch(IOException e){
			e.printStackTrace();
		}

		String[] nums = string.split(" ");
		int hang = Integer.parseInt(nums[0]);
		int lie = Integer.parseInt(nums[1]);

		if (hang != 0 && lie != 0){
			int[][] A = new int [hang][];
			for(int i = 0; i < hang; i++){
				A[i] = new int[lie];

				try{
					string = br.readLine();

				}catch(IOException e){
					e.printStackTrace();
				}

				nums = string.split(" ");
				for(int j = 0; j < lie; j++){
					A[i][j] = Integer.parseInt(nums[j]);
				}
			}

			//第二个矩阵读取
			try{
				string = br.readLine();

			}catch(IOException e){
				e.printStackTrace();
			}

			nums = string.split(" ");
			hang = Integer.parseInt(nums[0]);
			lie = Integer.parseInt(nums[1]);

			int[][] B = new int [hang][];
			for(int i = 0; i < hang; i++){
				B[i] = new int[lie];

				try{
					string = br.readLine();

				}catch(IOException e){
					e.printStackTrace();
				}

				nums = string.split(" ");
				for(int j = 0; j < lie; j++){
					B[i][j] = Integer.parseInt(nums[j]);
				}
			}

			return plus(A,B);
		}
		else{
			int[][] C = new int[0][0];
			return C;
		}
	}

	/**
	 * 输入格式同上方法相同
	 * 实现矩阵的乘法
	 * 返回一个新的矩阵
	 */
	public int[][] timesFromConsole(){
		// TODO
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String string = null;

		try{
			string = br.readLine();

		}catch(IOException e){
			e.printStackTrace();
		}

		String[] nums = string.split(" ");
		int hang = Integer.parseInt(nums[0]);
		int lie = Integer.parseInt(nums[1]);

		if (hang != 0 && lie != 0) {
			int[][] A = new int[hang][];
			for (int i = 0; i < hang; i++) {
				A[i] = new int[lie];

				try {
					string = br.readLine();

				} catch (IOException e) {
					e.printStackTrace();
				}

				nums = string.split(" ");
				for (int j = 0; j < lie; j++) {
					A[i][j] = Integer.parseInt(nums[j]);
				}
			}

			//第二个矩阵读取
			try {
				string = br.readLine();

			} catch (IOException e) {
				e.printStackTrace();
			}

			nums = string.split(" ");
			hang = Integer.parseInt(nums[0]);
			lie = Integer.parseInt(nums[1]);

			int[][] B = new int[hang][];
			for (int i = 0; i < hang; i++) {
				B[i] = new int[lie];

				try {
					string = br.readLine();

				} catch (IOException e) {
					e.printStackTrace();
				}

				nums = string.split(" ");
				for (int j = 0; j < lie; j++) {
					B[i][j] = Integer.parseInt(nums[j]);
				}
			}

			return times(A, B);
		}
		else{
			int[][] C = new int[0][0];
			return C;
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
	public void print(int[][] A){
		// TODO
		int hang = A.length;
		int lie = A[0].length;

		System.out.print("\n");

		for(int i = 0; i < hang; i++){
			for(int j = 0; j < lie - 1; j++){
				System.out.print(A[i][j] + " ");
			}
			System.out.println(A[i][lie - 1]);
		}

	}
}
