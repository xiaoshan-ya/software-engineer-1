package edu.nju;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
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
        thisQ=1;s=1;g=1;q0=1;f=1;b=1;n=1;delta=1;D=1;
    }
    int thisQ=0,s=0,g=0,q0=0,f=0,b=0,n=0,delta=0,D=1;
    //TODO
    public TuringMachine(String tm) {
        Delta=new HashSet<>();
        String[]sentences=tm.split("\n");
        ArrayList<String> Error=new ArrayList<>();
        G=new HashSet<>();
        Q=new HashSet<>();
        F=new HashSet<>();
        for (int i=0;i<sentences.length;i++){
            sentences[i]=sentences[i].trim();
            if (sentences[i].charAt(0)!='#'&&sentences[i].charAt(0)!=';'){
                int cnt=i+1;
                Error.add("Error: "+cnt);
            }
            if (sentences[i].charAt(0)=='#'){
                boolean left = sentences[i].contains("{");
                boolean right = sentences[i].contains("}");
                if (sentences[i].startsWith("#D")==false&&sentences[i].startsWith("#F")==false&&sentences[i].startsWith("#N")==false&&
                        sentences[i].startsWith("#S")==false&&sentences[i].startsWith("#Q")==false&&sentences[i].startsWith("#q0")==false&&
                        sentences[i].startsWith("#B")==false&&sentences[i].startsWith("#G")==false
                )
                {
                    int I=i+1;
                    Error.add("Error: "+I);
                }
                if (sentences[i].charAt(1)=='Q'||sentences[i].charAt(1)=='G'||sentences[i].charAt(1)=='S'||sentences[i].charAt(1)=='F'){
                    if (left == false || right == false){
                        int I=i+1;
                        Error.add("Error: "+I);
                    }
                    if (sentences[i].charAt(1)=='Q') {
                        thisQ = -1;
                    }
                    if (sentences[i].charAt(1)=='G') {
                        g= -1;
                    }
                    if (sentences[i].charAt(1)=='F') {
                        f = -1;
                    }
                    if (sentences[i].charAt(1)=='S') {
                        s = -1;
                    }
                }
                if (sentences[i].charAt(0)=='#'&&sentences[i].charAt(1)=='Q'&&left==true&&right==true){
                    thisQ=1;
                    sentences[i]=sentences[i].replace("#Q = {","");
                    sentences[i]=sentences[i].replace("}","");
                    String[] QWords=sentences[i].split(",");
                    for (int j=0;j<QWords.length;j++){
                        Q.add(QWords[j]);
                    }
                }
                if (sentences[i].charAt(0)=='#'&&sentences[i].charAt(1)=='D'){
                    delta=1;
                    sentences[i]=sentences[i].replace("#D ","");
                    sentences[i]=sentences[i].replace("\n","");
                    String[] Dealtas=sentences[i].split(" ");
                    if (Dealtas[1].length()==Dealtas[2].length()){
                        D=1;
                        TransitionFunction transitionFunction = new TransitionFunction(Dealtas[0],Dealtas[4], Dealtas[1] ,Dealtas[2],Dealtas[3]);
                        Delta.add(transitionFunction);
                    }
                }

                if (sentences[i].charAt(0)=='#'&&sentences[i].charAt(1)=='G'&&left==true&&right==true){
                    g=1;
                    sentences[i]=sentences[i].replace("#G = {","");
                    sentences[i]=sentences[i].replace("}","");
                    String[] Gwords= sentences[i].split(",");
                    char[] GWords=new char[Gwords.length];
                    for (int j = 0; j < Gwords.length; j++){
                        GWords[j]=Gwords[j].charAt(0);
                    }
                    for (int j=0;j<GWords.length;j++){
                        G.add(GWords[j]);
                    }
                }
                if (sentences[i].charAt(0)=='#'&&sentences[i].charAt(1)=='B'){
                    sentences[i]=sentences[i].replace("#B = ","");
                    b = 1;
                    B = sentences[i].charAt(0);
                    sentences[i] = sentences[i]+sentences[i];
                }
                if (sentences[i].charAt(0)=='#'&&sentences[i].charAt(1)=='S'&&left==true&&right==true){
                    S=new HashSet<>();
                    s=1;
                    sentences[i]=sentences[i].replace("#S = {","");
                    sentences[i]=sentences[i].replace("}","");
                    String[] Swords= sentences[i].split(",");
                    char[] SWords=new char[Swords.length];
                    for (int j=0;j< Swords.length;j++){
                        SWords[j]=Swords[j].charAt(0);
                    }
                    for (int j=0;j<Swords.length;j++){
                        S.add(SWords[j]);
                    }
                }
                if (sentences[i].charAt(0) == '#'&&sentences[i].charAt(1)=='F'&&left==true&&right==true&&sentences[i].length()>1){
                    f=1;

                    sentences[i]=sentences[i].replace("#F = {","");
                    sentences[i]=sentences[i].replace("}","");
                    String[] Fs=sentences[i].split(",");
                    for (int j=0;j<Fs.length;j++) {
                        F.add(Fs[j]);
                    }
                }
                if (sentences[i].charAt(0)=='#'&&sentences[i].charAt(1)=='N'){
                    n=1;
                    sentences[i]=sentences[i].replace("#N = ","");
                    tapeNum=Integer.parseInt(sentences[i]);
                    sentences[i]=sentences[i]+sentences[i];
                }
                if (sentences[i].charAt(0)=='#'&&sentences[i].charAt(1)=='q'){
                    q0=1;
                    sentences[i]=sentences[i].replace("#q0 = ","");
                    q=sentences[i];
                    sentences[i]=sentences[i]+sentences[i];
                }
            }//6.2写到缺括号和项
        }
        if (delta==0){
            Error.add("Error: lack D");
        }
        if (thisQ==0){
            Error.add("Error: lack Q");
        }
        if (g==0){
            Error.add("Error: lack G");
        }
        if (n==0){
            Error.add("Error: lack N");
        }
        if (s==0){
            Error.add("Error: lack S");
        }
        if (f==0){
            Error.add("Error: lack F");
        }
        if (b==0){
            Error.add("Error: lack B");
        }
        if (q0==0){
            Error.add("Error: lack q0");
        }
        if (D==0){
            Error.add("Error: lack Delta");
        }
        for (int i=0;i<Error.size();i++){
            //System.out.println(Error.get(i));
            System.err.println(Error.get(i));
        }

    }

    //TODO
    @Override
    public String toString() {
        String myString="";
        //Q
        if (thisQ==1){
            myString+="#Q = {";
            Iterator QI= Q.iterator();
            while (QI.hasNext()){
                myString+=QI.next()+",";
            }
            myString=myString.substring(0,myString.length()-1);
            myString+="}"+System.lineSeparator();
        }
        //S
        if (s==1){
            myString=myString+"#S = {";
            Iterator SI= S.iterator();
            while (SI.hasNext()){
                myString+=SI.next()+",";
            }
            myString=myString.substring(0,myString.length()-1);
            myString+="}"+System.lineSeparator();
        }
        //G
        if (g==1){
            myString+="#G = {";
            Iterator GI= G.iterator();
            while (GI.hasNext()){
                myString+=GI.next()+",";
            }
            myString=myString.substring(0,myString.length()-1);
            myString+="}"+System.lineSeparator();
        }
        //N
        if (n==1){
            myString+="#N = ";
            myString+=tapeNum+System.lineSeparator();
        }

        //F
        if (f==1){
            myString+="#F = {";
            Iterator FI= F.iterator();
            while (FI.hasNext()){
                myString+=FI.next()+",";
            }
            myString=myString.substring(0,myString.length()-1);
            myString+="}"+System.lineSeparator();
        }

        //q0
        if (q0==1){
            myString+="#q0 = ";
            myString+=q+System.lineSeparator();
        }
        //B
        if (b==1){
            myString+="#B = "+B+System.lineSeparator();
        }
        //D
        if (delta==1){
            Iterator DI= Delta.iterator();
            while (DI.hasNext()){
                myString+=DI.next().toString();
            }


        }
        myString=myString.substring(0,myString.length()-1);
        //TMSTR=TMSTR.substring(0,TMSTR.length()-1);
        return myString;
    }
}
