import java.io.BufferedReader;

public class Game {
    
    //游戏主方法playGame
    //输入为对弈双方轮番落子的位置，以英文逗号为间隔，X先走
    public Result playGame(String s){

        String[] location = s.split(",");
        String[] X_location = new String[location.length - location.length / 2];
        String[] O_location = new String[location.length / 2];

        //找出两个玩家下棋的位置
        int x = 0, o = 0;
        for (int i = 0; i < location.length; i++){
            if (i % 2 == 0){
                X_location[x] = location[i];
                x++;
            }
            else{
                O_location[o] = location[i];
                o++;
            }
        }

        //打印棋盘
        board_print(X_location, O_location);

        //判断玩家下棋的输赢
        if(whetherWin(X_location)){
            Result result = Result.X_WIN;
            return result;
        }
        else if (whetherWin(O_location)){
            Result result = Result.O_WIN;
            return result;
        }
        else if(location.length == 9 && !whetherWin(X_location) && !whetherWin(O_location)){
            Result result = Result.DRAW;
            return result;
        }
        else{
            Result result = Result.GAMING;
            return result;
        }

    }

    public boolean whetherWin(String[] x) {

        int flag = 0;
        for (int a = 0;a < x.length;a++){//判断A1 B1 C1的情况
            if (x[a].equals("A1")){ flag++; }
            if (x[a].equals("B1")){ flag++; }
            if (x[a].equals("C1")){ flag++; }

            if (flag == 3){ return true; }
        }

        flag = 0;
        for (int a = 0;a < x.length;a++){//判断A2 B2 C2的情况
            if (x[a].equals("A2")){ flag++; }
            if (x[a].equals("B2")){ flag++; }
            if (x[a].equals("C2")){ flag++; }

            if (flag == 3){ return true; }
        }

        flag = 0;
        for (int a = 0;a < x.length;a++){//判断A3 B3 C3的情况
            if (x[a].equals("A3")){ flag++; }
            if (x[a].equals("B3")){ flag++; }
            if (x[a].equals("C3")){ flag++; }

            if (flag == 3){ return true; }
        }

        flag = 0;
        for (int a = 0;a < x.length;a++){//判断A1 A2 A3的情况
            if (x[a].equals("A1")){ flag++; }
            if (x[a].equals("A2")){ flag++; }
            if (x[a].equals("A3")){ flag++; }

            if (flag == 3){ return true; }
        }

        flag = 0;
        for (int a = 0;a < x.length;a++){//判断B1 B2 B3的情况
            if (x[a].equals("B1")){ flag++; }
            if (x[a].equals("B2")){ flag++; }
            if (x[a].equals("B3")){ flag++; }

            if (flag == 3){ return true; }
        }

        flag = 0;
        for (int a = 0;a < x.length;a++){//判断C1 C2 C3的情况
            if (x[a].equals("C1")){ flag++; }
            if (x[a].equals("C2")){ flag++; }
            if (x[a].equals("C3")){ flag++; }

            if (flag == 3){ return true; }
        }

        flag = 0;
        for (int a = 0;a < x.length;a++){//判断A1 B2 C3的情况
            if (x[a].equals("A1")){ flag++; }
            if (x[a].equals("B2")){ flag++; }
            if (x[a].equals("C3")){ flag++; }

            if (flag == 3){ return true; }
        }

        flag = 0;
        for (int a = 0;a < x.length;a++){//判断A3 B2 C1的情况
            if (x[a].equals("A3")){ flag++; }
            if (x[a].equals("B2")){ flag++; }
            if (x[a].equals("C1")){ flag++; }

            if (flag == 3){ return true; }
        }

        return false;
    }//判断输赢

    public int position(String x) {

        int location = 0;
        switch (x){
            case "A1":
                location = 0;
                break;
            case "B1":
                location = 1;
                break;
            case "C1":
                location = 2;
                break;
            case "A2":
                location = 3;
                break;
            case "B2":
                location = 4;
                break;
            case "C2":
                location = 5;
                break;
            case "A3":
                location = 6;
                break;
            case "B3":
                location = 7;
                break;
            case "C3":
                location = 8;
                break;
        }

        return location;
    }//找到下棋的位置

    public String[] X_broad(String x, String[] broad){

        int location = position(x);
        broad[location] = "X";
        return broad;
    }//添加X下棋的位置

    public String[] O_broad(String o, String[] broad){

        int location = position(o);
        broad[location] = "O";
        return broad;
    }//添加O下棋的位置

    public void board_print(String[] X_location, String[] O_location){
        String[] broad = new String[9];//棋盘初始化
        for (int i = 0; i < 9; i++){
            broad[i] = "_";
        }

        int X = 0, O = 0;
        for (int i = 0; i < X_location.length + O_location.length; i++){
            if (i % 2 == 0){
                broad = X_broad(X_location[X],broad);
                System.out.println("  A B C");
                System.out.println("1 " + broad[0] + " " + broad[1] + " " + broad[2]);
                System.out.println("2 " + broad[3] + " " + broad[4] + " " + broad[5]);
                System.out.println("3 " + broad[6] + " " + broad[7] + " " + broad[8]);
                X++;
            }
            else{
                broad = O_broad(O_location[O],broad);
                System.out.println("  A B C");
                System.out.println("1 " + broad[0] + " " + broad[1] + " " + broad[2]);
                System.out.println("2 " + broad[3] + " " + broad[4] + " " + broad[5]);
                System.out.println("3 " + broad[6] + " " + broad[7] + " " + broad[8]);
                O++;
            }
        }
    }//打印棋盘

    
    public static void main(String[] args){
        Game game = new Game();
        Result result = game.playGame("A1,B1,B2,B3,C3");
        System.out.println(result);


    }
}
