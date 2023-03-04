package cn.edu.nju.TicTacToe;
/**
 * 横竖斜方式获胜对应的类，应该考虑到可扩展性，当有新的获胜模式出现时更易于添加
 * hint：采用接口的方式，接口与实现相分离
 * @author Xin Feng & Qiu Liu
 *
 */
public class GameWinStrategy_HVD {
	/**
	 * 根据需要修改获胜的方法
	 * @param cells  棋盘对应的char二维数组
	 * @return  检测结果
	 */
	public Result check(char[][] cells){

		for (int i = 0; i < cells.length; i++){//检查横着的
			for (int j = 0; j < cells[0].length - 2; j++){
				if (cells[i][j] == 'X' && cells[i][j + 1] == 'X' && cells[i][j + 2] == 'X'){ return Result.X_WIN; }
				else if (cells[i][j] == 'O' && cells[i][j + 1] == 'O' && cells[i][j + 2] == 'O') { return Result.O_WIN; }
			}
		}

		for (int i = 0 ; i < cells.length; i++){//检查竖着的
			for (int j = 0; j < cells[0].length - 2; j++){
				if (cells[j][i] == 'X' && cells[j + 1][i] == 'X' && cells[j + 2][i] == 'X'){ return Result.X_WIN; }
				else if (cells[j][i] == 'O' && cells[j + 1][i] == 'O' && cells[j + 2][i] == 'O') { return Result.O_WIN; }
			}
		}

		for (int i = 0; i < cells.length - 2; i++){//检查右斜着的
			for (int j = 0; j < cells[0].length - 2; j++){
				if (cells[i][j] == 'X' && cells[i + 1][j + 1] == 'X' && cells[i + 2][j + 2] == 'X'){ return Result.X_WIN; }
				else if (cells[i][j] == 'O' && cells[i + 1][j + 1] == 'O' && cells[i + 2][j + 2] == 'O'){ return Result.O_WIN; }
			}
		}

		for (int i = 0; i < cells.length - 2; i++){//检查左斜着的
			for (int j = 2; j < cells[0].length; j++){
				if (cells[i][j] == 'X' && cells[i + 1][j - 1] == 'X' && cells[i + 2][j - 2] == 'X'){ return Result.X_WIN; }
				else if (cells[i][j] == 'O' && cells[i + 1][j - 1] == 'O' && cells[i + 2][j - 2] == 'O'){ return Result.O_WIN; }
			}
		}

		for (int i = 0; i < cells.length; i++){
			for (int j = 0; j < cells[0].length; j++){
				if (cells[i][j] == '_'){
					return Result.GAMING;
				}
			}
		}

		return Result.DRAW;

	}
}