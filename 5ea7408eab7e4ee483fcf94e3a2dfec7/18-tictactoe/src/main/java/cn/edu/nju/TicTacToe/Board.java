package cn.edu.nju.TicTacToe;

import java.util.ArrayList;

public class Board {
	/**
	 * 成员变量的初始化代码请修改，请灵活选择初始化方式
	 * 必要时可添加成员变量
	 */
	protected char[][] cells;
	protected GameChessStrategy chessStrategy;
	protected GameWinStrategy_HVD winStrategy_hvd;
	protected GameWinStrategy_HV winStrategy_hv;
	protected Player player = Player.X;
	public ArrayList<String> XList = new ArrayList<>();
	public ArrayList<String> OList = new ArrayList<>();

	/**
	 * 请修改构造方法，并添加合适的构造方法
	 */
	public Board(int size,String gamemode){
		cells = new char[size][size];
		for(int i=0; i<size; i++){
			for(int j=0; j<size; j++){
				cells[i][j] = '_';
			}
		}

		if (gamemode.equals("00") || gamemode.equals("10")) { winStrategy_hvd = new GameWinStrategy_HVD(); }
		else if (gamemode.equals("01")|| gamemode.equals("11")){ winStrategy_hv = new GameWinStrategy_HV(); }

		chessStrategy = new GameChessStrategy();
	}

	
	public Board(int size, String gamemode, GameChessStrategy chessStrategy, GameWinStrategy_HVD winStrategy){
		cells = new char[size][size];
		for(int i=0; i<size; i++){
			for(int j=0; j<size; j++){
				cells[i][j] = '_';
			}
		}

		if (gamemode.equals("00") || gamemode.equals("10")) { winStrategy_hvd = new GameWinStrategy_HVD(); }
		else if (gamemode.equals("01")|| gamemode.equals("11")){ winStrategy_hv = new GameWinStrategy_HV(); }

		chessStrategy = new GameChessStrategy();

		if (gamemode.equals("00") || gamemode.equals("10")){ this.winStrategy_hvd = winStrategy_hvd; }
		else if (gamemode.equals("01")|| gamemode.equals("11")) { this.winStrategy_hv = winStrategy_hv; }

	}

	/**
	 * @param move 下棋的位置
	 * @return 落棋之后的结果
	 */
	int p = 1;
	public Result nextMove(String move,String gamemode) {

		if (gamemode.equals("10") || gamemode.equals("11")) {
			if (p == 1) {
				XList.add(move);
				p = 0;
				if (XList.size() > 5) {
					String chessPos = XList.get(XList.size() - 6);
					chessStrategy.outChess(cells, chessPos);
				}
			} else if (p == 0) {
				OList.add(move);
				p = 1;
				if (OList.size() > 5) {
					String chessPos = OList.get(OList.size() - 6);
					chessStrategy.outChess(cells, chessPos);
				}
			}
		}

		chessStrategy.putChess(cells, nextPlay(), move);

		if (gamemode.equals("01") || gamemode.equals("11")){ return winStrategy_hv.check(cells); }
		else if (gamemode.equals("00") || gamemode.equals("10")){ return winStrategy_hvd.check(cells); }

		return null;
	}
	
	/**
	 * @return 下一个落棋的玩家
	 */
	protected Player nextPlay(){
		Player res = player;
		player = player == Player.X ? Player.O : Player.X;
		return res;
	}
	
	/**
	 * 棋盘的输出方法，根据需要进行修改
	 */
	public void print(int size){
		System.out.print(" ");
		for (int x = 0; x < size;x++){
			char lie = (char)('A' + x);
			System.out.print(" " + lie);
		}

		System.out.println("");

		for(int i=0 ;i<size; i++){
			System.out.print(i+1);
			for(int j=0; j<size; j++){
				System.out.print(" "+cells[i][j]);
			}
			System.out.println();
		}
	}
}