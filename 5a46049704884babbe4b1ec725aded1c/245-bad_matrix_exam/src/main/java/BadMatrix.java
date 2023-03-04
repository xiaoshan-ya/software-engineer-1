

import java.util.Arrays;

/**
 * 矩阵类，实现矩阵的加法，矩阵乘法
 * 1.传入一个int[][]进行2个矩阵的操作
 * 2.返回一个int[][]
 * 所有的数据均为int型
 * 输入数据均默认为正确数据，不需要对输入数据进行校验
 * @author Qin Liu
 *
 */
public class BadMatrix {
	private int[][] data;
	
	/**
	 * 构造函数，参数为2维int数组
	 * a[i][j]是矩阵中的第i+1行，第j+1列数据
	 * @param a
	 */
	public BadMatrix(int[][] a){ this.data = a; }

	public int[][] getData() {
		return data;
	}

	
	/**
	 * 实现矩阵加法，返回一个新的矩阵
	 * @param b
	 * @return
	 */
    public int[][] plus(int[][] b){

		int hang = data.length;
		int lie = data[0].length;

		int[][] c = new int[hang][];
		for (int i = 0; i < hang; i++){
			c[i] = new int[lie];
			for (int j = 0; j < lie; j++){
				c[i][j] = data[i][j] + b[i][j];
			}
		}

		return c;
	}
        
	
	/**
	 * 实现矩阵乘法，返回一个新的矩阵
	 * @param b
	 * @return
	 */
	public int[][] times(int[][] b){
		int hang = data.length;
		int lie = b[0].length;

		int[][] c =  new int[hang][];
		for (int i = 0; i < hang; i++){
			c[i] = new int[lie];
			for (int j = 0; j < lie; j ++){
				c[i][j] = 0;

				for (int y = 0; y < data.length;y++){
					c[i][j] += data[i][y] + b[y][j];
				}
			}
		}

		return c;
	}

	//不要修改下面print方法
	/**
	 * 打印出该矩阵的数据
	 * 
	 */
	public void print(){
		System.out.print(this.toString());
	}

	/**
	 * 实现toString方法
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
	public String toString(){
		int hang = data.length;
		int lie = data[0].length;

		System.out.println("");

		for (int i = 0; i < hang; i++){
			for (int j = 0; j < lie - 1; j++){
				System.out.print(data[i][j] + " ");
			}
			System.out.println(data[i][lie - 1]);
		}

		return "";
	}

	//不要修改下面equals方法
	public boolean equals(Object o){
		if(this.toString().equals(((BadMatrix)o).toString()))
			return true;
		else
			return false;
	}
}
