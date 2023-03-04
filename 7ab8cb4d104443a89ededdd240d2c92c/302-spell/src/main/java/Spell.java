public class Spell {
    public boolean spell(int x,int y){
        //add code here
        if (x == 1 && y == 1){
            return true;
        }

        if (x >= y){
            return true;
        }
        else{
            int cnt = 0;
             while(true){
                 cnt += 1;
                 if (x % 2 == 1){ x -= 1; }
                 else{
                     x = x / 2 * 3;
                 }
                 if (x >= y){ return true; }
                 if (cnt > 1000){ return false; }
            }
        }

    }
}
