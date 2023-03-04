package edu.nju;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @Author: pkun
 * @CreateTime: 2021-05-23 16:15
 */
public class TuringMachine {

    // 状态集合
    Set<String> Q;
    // 输入符号集
    Set<Character> S;
    // 磁带符号集
    Set<Character> G;
    // 初始状态
    String q;
    // 终止状态集
    Set<String> F;
    // 空格符号
    Character B;
    // 磁带数
    Integer tapeNum;
    // 迁移函数集
    Set<TransitionFunction> Delta;

    public TuringMachine(Set<String> Q, Set<Character> S, Set<Character> G, String q, Set<String> F, char B, int tapeNum, Set<TransitionFunction> Delta) {
        this.Q = Q;
        this.S = S;
        this.G = G;
        this.q = q;
        this.F = F;
        this.B = B;
        this.tapeNum = tapeNum;
        this.Delta = Delta;
    }

    //TODO
    public TuringMachine(String tm) {
        //对变量进行初始化，集合中没有相同的元素
        Q = new HashSet<>();
        S = new HashSet<>();
        G = new HashSet<>();
        q = null;
        F = new HashSet<>();
        B = null;
        tapeNum = 0;
        Delta = new HashSet<>();

        String[] sentences = tm.split("\n");//得到每一行输入流
        int cnt = -1;
        int qjudge = 0;
        int s = 0;
        int g = 0;
        int q0 = 0;
        int b = 0;
        int f = 0;
        int n = 0;
        int d = 0;
        int i;
        String result;
        ArrayList<String> error = new ArrayList<>();
        for (int j = 0; j < sentences.length; j++) {
            cnt += 1;
            result = "Error: ";
            if (true) {
                String scentence = sentences[j].trim();//先删去前面的空格
                if (scentence.charAt(0) == '#') {
                    switch (scentence.substring(0, 2)) {
                        case "#Q":
                            qjudge = 1;
                            //①对缺少括号的情况进行判断
                            if (scentence.charAt(5) != '{' || scentence.charAt(scentence.length() - 1) != '}') {
                                result += cnt;
                                error.add(result);
                            } else {
                                scentence = scentence.replace("#Q = {", "");
                                scentence = scentence.replace("}", "");//得到括号内的字符串
                                String[] words = scentence.split(",");
                                for (i = 0; i < words.length; i++) {
                                    Q.add(words[i]);
                                }
                            }

                            break;

                        case "#S":
                            s = 1;
                            //①对缺少括号的情况进行判断
                            if (scentence.charAt(5) != '{' || scentence.charAt(scentence.length() - 1) != '}') {
                                result += cnt;
                                error.add(result);
                            } else {
                                scentence = scentence.replace("#S = {", "");
                                scentence = scentence.replace("}", "");//得到括号内的字符串
                                String[] words = scentence.split(",");
                                char[] SChar = new char[words.length];
                                for (i = 0; i < words.length; i++) {
                                    SChar[i] = words[i].charAt(0);
                                }
                                for (i = 0; i < words.length; i++) {
                                    S.add(SChar[i]);
                                }
                            }
                            break;
                        case "#G":
                            g = 1;
                            //①对缺少括号的情况进行判断
                            if (scentence.charAt(5) != '{' || scentence.charAt(scentence.length() - 1) != '}') {
                                result += cnt;
                                error.add(result);
                            }
                             else {
                                scentence = scentence.replace("#G = {", "");
                                scentence = scentence.replace("}", "");//得到括号内的字符串
                                String[] words = scentence.split(",");
                                char[] GChar = new char[words.length];
                                for (i = 0; i < words.length; i++) {
                                    GChar[i] = words[i].charAt(0);
                                }
                                for (i = 0; i < words.length; i++) {
                                    G.add(GChar[i]);
                                }
                            }
                            break;

                        case "#B":
                            b = 1;
                            //②对格式进行判断、③对缺失部分进行标记
                            if (!scentence.startsWith(" = ", 2)) {
                                result += cnt;
                                error.add(result);
                            }
                            if (scentence.charAt(5) != '_') {
                                error.add(result + cnt);
                            }
                            else{
                                B = '_';
                            }
                            break;

                        case "#F":
                            f = 1;
                            //①对缺少括号的情况进行判断
                            if (scentence.charAt(5) != '{' || scentence.charAt(scentence.length() - 1) != '}') {
                                result += cnt;
                                error.add(result);
                            }
                            else{
                                scentence = scentence.replace("#F = {" , "");
                                scentence = scentence.replace("}" , "");//得到括号内的字符串
                                String[] words = scentence.split(",");
                                for (i = 0; i < words.length; i++){
                                    F.add(words[i]);
                                }
                            }
                            break;

                        case "#N":
                            n = 1;
                            tapeNum = Integer.parseInt(scentence.substring(5));
                            break;

                        case "#D":
                            d = 1;
                            //②对格式进行判断、③对缺失部分进行标记
                            scentence = scentence.substring(3);//得到括号内的字符串
                            String[] words = scentence.split(" ");

                            //删去部分代码

                            TransitionFunction transitionFunction = new TransitionFunction(words[0], words[4], words[1], words[2], words[3]);
                            Delta.add(transitionFunction);
                            break;
                    }

                    if (scentence.startsWith("#q0", 0)) {
                        q0 = 1;
                        q = scentence.substring(6);
                    }
                }
            }
            //③对缺失进行判断
            if (qjudge == 0) {
                error.add("Error: lack Q");
            }
            if (s == 0) {
                error.add("Error: lack S");
            }
            if (g == 0) {
                error.add("Error: lack G");
            }
            if (q0 == 0) {
                error.add("Error: lack q0");
            }
            if (b == 0) {
                error.add("Error: lack B");
            }
            if (f == 0) {
                error.add("Error: lack F");
            }
            if (n == 0) {
                error.add("Error: lack N");
            }
            if (d == 0) {
                error.add("Error: lack D");
            }

            for (i = 0; i < error.size(); i++) {
                System.err.println(error.get(i));
            }

        /*填入set的内容——mytodo
        Q = getQ(sentences , Q);
        S = getS(sentences , S);
        G = getG(sentences , G);
        q = getq(sentences , q);
        F = getF(sentences , F);
        B = getB(sentences , B);
        tapeNum = getTapeNum(sentences , tapeNum);
        //Delta在判断正误后已经填入，因为再写一遍太麻烦了，实在懒得写
        */


        }
    }

    //TODO
    @Override
    public String toString() {
        String myString = "";
        //Q
        if (Q != null) {
            myString += "#Q = {";
            Iterator QI = Q.iterator();
            while (QI.hasNext()) {
                myString += QI.next() + ",";
            }
            myString = myString.substring(0, myString.length() - 1);
            myString += "}" + "\n";

        }
        //S
        if (S != null) {
            myString += "#S = {";
            Iterator SI = S.iterator();
            while (SI.hasNext()) {
                myString += SI.next() + ",";
            }
            myString = myString.substring(0, myString.length() - 1);
            myString += "}" + "\n";

        }
        //G
        if (G != null) {
            myString += "#G = {";
            Iterator GI = G.iterator();
            while (GI.hasNext()) {
                myString += GI.next() + ",";
            }
            myString = myString.substring(0, myString.length() - 1);
            myString += "}" + System.lineSeparator();

        }
        //q
        if (q != null) {
            myString += "#q0 = " + q + System.lineSeparator();

        }
        //F
        if (F != null) {
            myString += "#F = {";
            Iterator FI = F.iterator();
            while (FI.hasNext()) {
                myString += FI.next() + ",";
            }
            myString = myString.substring(0, myString.length() - 1);
            myString += "}" + System.lineSeparator();

        }
        //B
        if (B != null) {
            myString += "#B = " + B + System.lineSeparator();

        }
        //tapeNum
        if (tapeNum != 0) {
            myString += "#N = " + tapeNum + System.lineSeparator();
        }
        //Delta
        if (Delta != null) {
            Iterator DI = Delta.iterator();
            while (DI.hasNext()) {
                myString += DI.next().toString();
            }
        }
        myString.substring(0, myString.length() - 1);
        return myString;
    }
}

/*
    public Set<String> getQ(String[] sentences , Set<String> Q) {
        for (String sentence : sentences){
            sentence = sentence.trim();
            if (sentence.startsWith("#Q" , 0)){
                if (sentence.charAt(5) != '{' || sentence.charAt(sentence.length() - 1) != '}') { return null; }
                if (!sentence.startsWith(" = ", 2)) { return null; }
                sentence = sentence.replace("#Q = {" , "");
                sentence = sentence.replace("}" , "");//得到括号内的字符串
                String[] words = sentence.split(",");
                for (String word : words) {
                    for (int i = 0; i < word.length(); i++) {
                        if (word.charAt(i) >= '0' && word.charAt(i) <= '9') { continue; }
                        else if (word.charAt(i) >= 'a' && word.charAt(i) <= 'z') { continue; }
                        else if (word.charAt(i) >= 'A' && word.charAt(i) <= 'Z') { continue; }
                        else { return null; }
                    }
                }
                //当前面的情况都满足时，表示这一行没有出现错误
                for (int i = 0; i < words.length; i++){
                    Q.add(words[i]);
                }
                break;
            }
        }
        return Q;
    }

    public Set<Character> getS(String[] sentences , Set<Character> S){
        for (String sentence : sentences) {
            sentence = sentence.trim();
            if (sentence.startsWith("#S", 0)) {
                if (sentence.charAt(5) != '{' || sentence.charAt(sentence.length() - 1) != '}') { return null; }
                if (!sentence.startsWith(" = ", 2)) { return null; }
                sentence = sentence.replace("#S = {" , "");
                sentence = sentence.replace("}" , "");//得到括号内的字符串
                String[] words = sentence.split(",");
                for (String word : words) {
                    for (int i = 0; i < word.length(); i++) {
                        if (word.charAt(i) == ' ') { return null; }
                        if (word.charAt(i) == ';') { return null; }
                        if (word.charAt(i) == '{') { return null; }
                        if (word.charAt(i) == '}') { return null; }
                        if (word.charAt(i) == '*') { return null; }
                        if (word.charAt(i) == '_') { return null; }
                    }
                }
                for (int i = 6; i < words.length; i++){
                    S.add(sentence.charAt(i));
                }
                break;
            }
        }
        return S;
    }

    public Set<Character> getG(String[] sentences , Set<Character> G){
        for (String sentence : sentences){
            sentence = sentence.trim();
            if (sentence.startsWith("#G", 0)){
                if (sentence.charAt(5) != '{' || sentence.charAt(sentence.length() - 1) != '}') { return null; }
                if (!sentence.startsWith(" = ", 2)) { return null; }
                sentence = sentence.replace("#G = {" , "");
                sentence = sentence.replace("}" , "");//得到括号内的字符串
                String[] words = sentence.split(",");
                for (String word : words) {
                    for (int i = 0; i < word.length(); i++) {
                        if (word.charAt(i) == ' ') { return null; }
                        if (word.charAt(i) == ';') { return null; }
                        if (word.charAt(i) == '{') { return null; }
                        if (word.charAt(i) == '}') { return null; }
                        if (word.charAt(i) == '*') { return null; }

                    }
                }
                for (int i = 6; i < words.length; i++){
                    G.add(sentence.charAt(i));
                }
                break;
            }
        }
        return G;
    }

    public String getq(String[] sentences , String q){
        for (String sentence : sentences){
            sentence = sentence.trim();
            if (sentence.startsWith("#q0", 0)){
                if (!sentence.startsWith(" = ", 3)) { return null; }
                String my_q0 = sentence.substring(6);
                for (int i = 0; i < my_q0.length(); i++) {
                    if (my_q0.charAt(i) >= '0' && my_q0.charAt(i) <= '9') { continue; }
                    else if (my_q0.charAt(i) >= 'a' && my_q0.charAt(i) <= 'z') { continue; }
                    else if (my_q0.charAt(i) >= 'A' && my_q0.charAt(i) <= 'Z') { continue; }
                    else { return null; }
                }
                q = sentence.substring(6);
                break;
            }
        }
        return q;
    }

    public Character getB(String[] sentences , Character B){
        for (String sentence : sentences){
            sentence = sentence.trim();
            if (sentence.startsWith("#B", 0)){
                if (!sentence.startsWith(" = ", 2)) { return null; }
                if (sentence.charAt(5) != '_'){ return null; }
                B = '_';
            }
        }
        return B;
    }

    public Set<String> getF(String[] sentences , Set<String> F){
        for (String sentence : sentences){
            sentence = sentence.trim();
            if (sentence.startsWith("#F", 0)){
                if (sentence.charAt(5) != '{' || sentence.charAt(sentence.length() - 1) != '}') { return null; }
                if (!sentence.startsWith(" = ", 2)) { return null; }
                sentence = sentence.replace("#F = {" , "");
                sentence = sentence.replace("}" , "");//得到括号内的字符串
                String[] words = sentence.split(",");
                for (int i = 0; i < words.length; i++){
                    F.add(words[i]);
                }
                break;
            }
        }
        return F;
    }

    public  Integer getTapeNum(String[] sentences , Integer tapeNum){
        for (String sentence : sentences){
            sentence = sentence.trim();
            if (sentence.startsWith("#N", 0)){
                if (!sentence.startsWith(" = ", 2)) { return null; }
                for (int i = 5; i < sentence.length(); i++){
                    if (sentence.charAt(i) >= '9' || sentence.charAt(i) <= '0'){ return null; }
                }
                tapeNum = Integer.parseInt(sentence.substring(5));
                break;
            }
        }
        return tapeNum;
    }

}
*/



