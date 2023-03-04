public String checkError(String sentence , int cnt , int i) {
        String result = "Error: ";

        int q = 0;
        int s = 0;
        int g = 0;
        int q0 = 0;
        int b = 0;
        int f = 0;
        int n = 0;
        int d = 0;

        String scentence = sentence.trim();//先删去前面的空格

        if (scentence.charAt(0) == '#') {
        //①对缺少括号的情况进行判断
        if (scentence.charAt(5) != '{' || scentence.charAt(scentence.length() - 1) != '}') {
        result += "[" + cnt + "]";
        return result;
        }

        //②对格式进行判断、③对缺失部分进行标记
        if (!scentence.startsWith(" = ", 2)) {
        result += "[" + cnt + "]";
        return result;
        }
        switch (scentence.substring(0, 2)) {
        case "#Q":
        q = 1;
        scentence = scentence.substring(6);//得到括号内的字符串
        String[] words = scentence.split(",");
        for (String word : words) {
        for (i = 0; i < word.length(); i++) {
        if (word.charAt(i) > '0' && word.charAt(i) < '9') {
        continue;
        } else if (word.charAt(i) > 'a' && word.charAt(i) < 'z') {
        continue;
        } else if (word.charAt(i) > 'A' && word.charAt(i) < 'Z') {
        continue;
        } else {
        return result += "[" + cnt + "]";
        }
        }

        }
        break;

        case "#S":
        s = 1;
        scentence = scentence.substring(6);//得到括号内的字符串
        words = scentence.split(",");
        for (String word : words) {
        for (i = 0; i < word.length(); i++) {
        if (word.charAt(i) == ' ') { return result += "[" + cnt + "]"; }
        if (word.charAt(i) == ';') { return result += "[" + cnt + "]"; }
        if (word.charAt(i) == '{') { return result += "[" + cnt + "]"; }
        if (word.charAt(i) == '}') { return result += "[" + cnt + "]"; }
        if (word.charAt(i) == '*') { return result += "[" + cnt + "]"; }
        if (word.charAt(i) == '_') { return result += "[" + cnt + "]"; }
        }
        }
        break;

        case "#G":
        g = 1;
        scentence = scentence.substring(6);//得到括号内的字符串
        words = scentence.split(",");
        for (String word : words) {
        for (i = 0; i < word.length(); i++) {
        if (word.charAt(i) == ' ') { return result += "[" + cnt + "]"; }
        if (word.charAt(i) == ';') { return result += "[" + cnt + "]"; }
        if (word.charAt(i) == '{') { return result += "[" + cnt + "]"; }
        if (word.charAt(i) == '}') { return result += "[" + cnt + "]"; }
        if (word.charAt(i) == '*') { return result += "[" + cnt + "]"; }
        }
        }
        break;

        case "#B":
        b = 1;
        if (scentence.charAt(5) != '_'){ return result += "[" + cnt + "]"; }
        break;

        case "#F":
        f = 1;
        break;

        case "#N":
        n = 1;
        for (i = 5;i < scentence.length(); i++){
        if (scentence.charAt(i) > '9' || scentence.charAt(i) < '0'){ return result += "[" + cnt + "]"; }
        }
        break;

        case "#D":
        d = 1;
        scentence = scentence.substring(3);//得到括号内的字符串
        words = scentence.split(" ");

        //判断旧状态组
        for (i = 0; i < words[0].length(); i++){
        if (words[0].charAt(i) >'0' && words[0].charAt(i) < '9'){ continue; }
        else if (words[0].charAt(i) >'a' && words[0].charAt(i) < 'z'){ continue; }
        else if (words[0].charAt(i) >'A' && words[0].charAt(i) < 'Z'){ continue; }
        else { return result += "[" + cnt + "]"; }
        }

        //判断新状态
        for (i = 0; i < words[4].length(); i++) {
        if (words[4].charAt(i) > '0' && words[0].charAt(i) < '9') { continue; }
        else if (words[4].charAt(i) > 'a' && words[0].charAt(i) < 'z') { continue; }
        else if (words[4].charAt(i) > 'A' && words[0].charAt(i) < 'Z') { continue; }
        else { return result += "[" + cnt + "]"; }
        }

        //判断旧符号组
        for (i = 0; i < words[1].length(); i++){
        if (words[1].charAt(i) == ' ') { return result += "[" + cnt + "]"; }
        if (words[1].charAt(i) == ';') { return result += "[" + cnt + "]"; }
        if (words[1].charAt(i) == '{') { return result += "[" + cnt + "]"; }
        if (words[1].charAt(i) == '}') { return result += "[" + cnt + "]"; }
        if (words[1].charAt(i) == '*') { return result += "[" + cnt + "]"; }
        }

        //判断新符号组
        for (i = 0; i < words[3].length(); i++){
        if (words[2].charAt(i) == ' ') { return result += "[" + cnt + "]"; }
        if (words[2].charAt(i) == ';') { return result += "[" + cnt + "]"; }
        if (words[2].charAt(i) == '{') { return result += "[" + cnt + "]"; }
        if (words[2].charAt(i) == '}') { return result += "[" + cnt + "]"; }
        if (words[2].charAt(i) == '*') { return result += "[" + cnt + "]"; }
        }

        //判断方向
        for (i = 0; i < words[3].length(); i++) {
        if (words[3].charAt(i) != 'l' || words[3].charAt(i) != 'r' || words[3].charAt(i) != '*') {
        return result += "[" + cnt + "]";
        }
        }

        TransitionFunction transitionFunction = new TransitionFunction(words[0],words[4],words[1],words[2],words[3]);
        Delta.add(transitionFunction);
        break;

default:

        }
        if (scentence.startsWith("#q0",0)){
        q0 = 1;
        String my_q0 = scentence.substring(6);
        for (i = 0; i < my_q0.length(); i++) {
        if (my_q0.charAt(i) > '0' && my_q0.charAt(i) < '9') { continue; }
        else if (my_q0.charAt(i) > 'a' && my_q0.charAt(i) < 'z') { continue; }
        else if (my_q0.charAt(i) > 'A' && my_q0.charAt(i) < 'Z') { continue; }
        else { return result += "[" + cnt + "]"; }
        }
        }

        }
        else { return null; }

        //③对缺失进行判断
        if (q == 0){ return result += "lack " + "Q"; }
        if (s == 0){ return result += "lack " + "S"; }
        if (g == 0){ return result += "lack " + "G"; }
        if (q0 == 0){ return result += "lack " + "q0"; }
        if (b == 0){ return result += "lack " + "B"; }
        if (f == 0){ return result += "lack " + "F"; }
        if (n == 0){ return result += "lack " + "N"; }
        if (d == 0){ return result += "lack " + "Delta"; }

        //对Delta内容进行判断

        return null;
        }//检查tm中错误的方法