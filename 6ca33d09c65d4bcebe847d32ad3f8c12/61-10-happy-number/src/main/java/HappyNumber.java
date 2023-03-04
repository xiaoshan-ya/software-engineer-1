
public class HappyNumber {

    public static boolean isHappy(int n) {
        for (int cnt = 0; ; cnt += 1){
            if (cnt > 1000) { return false; }
            if (afterCount(n) == 1) { return true; }
            n = afterCount(n);
        }
    }

    public static int afterCount(int n){
        String num = n + "";
        String[] nums = num.split("");
        int result = 0;
        for (String number: nums){
            int myNum = Integer.parseInt(number);
            result += myNum * myNum;
        }
        return result;
    }

}
