package edu.nju;

import java.util.*;

/**
 * @Author: pkun
 * @CreateTime: 2021-05-23 16:15
 */
public class TuringMachine {

    // 状态集合
    private final Map<String, State> Q;
    // 输入符号集
    private Set<Character> S;
    // 磁带符号集
    private Set<Character> G;
    // 初始状态
    private String q0;
    // 终止状态集
    private Set<String> F;
    // 空格符号
    private Character B;
    // 磁带数
    private Integer tapeNum;

    public TuringMachine(Set<String> Q, Set<Character> S, Set<Character> G, String q, Set<String> F, char B, int tapeNum, Set<TransitionFunction> Delta) {
        this.S = S;
        this.G = G;
        this.F = F;
        this.B = B;
        this.q0 = q;
        this.Q = new HashMap<>();
        for (String state : Q) {
            State temp = new State(state);
            temp.setQ(state);
            this.Q.put(state, temp);
        }
        this.tapeNum = tapeNum;
        for (TransitionFunction t : Delta) {
            this.Q.get(t.getSourceState().getQ()).addTransitionFunction(t);
        }
    }

    /**
     * TODO
     * is done in Lab1 ~
     *
     * @param tm
     */
    public TuringMachine(String tm) {
        this.Q = new HashMap<>();
        boolean _flag=false;
        // 状态集合
        Set<String> Q = new HashSet<>();
        // 输入符号集
        Set<Character> S = new HashSet<>();
        // 磁带符号集
        Set<Character> G = new HashSet<>();
        // 初始状态
        String q = null;
        // 终止状态集
        Set<String> F = new HashSet<>();
        // 空格符号
        char B='?';
        // 磁带数
        int tapeNum = 0;
        // 迁移函数集
        ArrayList<TransitionFunction> Delta  = new ArrayList<>();
        boolean[] flag={false,false,false,false,false,false,false,false};
        int count=0;
        String[] syms = null;
        if (!tm.equals("")){
            String[] lines=tm.split(System.lineSeparator());
            int p_0;
            String line;
            for (int i=0;i<lines.length;i++) {
                do {
                    p_0=0;
                    line = lines[i].substring(p_0);
                    p_0 = line.indexOf("#") + 1;
                    if (p_0 != 0) {
                        int p_1 = line.indexOf("{");
                        int p_2 = line.indexOf("}");
                        String te = line.substring(p_0, p_0 + 1);
                        if (line.indexOf("Q") == p_0 || line.indexOf("F") == p_0 ||
                                line.indexOf("S") == p_0 || line.indexOf("G") == p_0) {
                            if (p_1 == -1 || p_2 == -1) {
                                System.err.println("Error: " + (i + 1));
                                if (line.indexOf("Q") == p_0) flag[0] = true;
                                if (line.indexOf("F") == p_0) flag[1] = true;
                                if (line.indexOf("S") == p_0) flag[2] = true;
                                if (line.indexOf("G") == p_0) flag[3] = true;
                            } else {
                                syms = line.substring(p_1 + 1, p_2).split(",");
                                if (line.indexOf("Q") == p_0) {
                                    for (int j = 0; j < syms.length; j++) {
                                        String tes = syms[j].trim();
                                        Q.add(tes);
                                        flag[0] = true;
                                        _flag=true;
                                    }
                                } else if (line.indexOf("F") == p_0) {
                                    for (int j = 0; j < syms.length; j++) {
                                        F.add(syms[j]);
                                        flag[1] = true;
                                    }
                                } else if (line.indexOf("S") == p_0) {
                                    for (String sym : syms) {
                                        S.add(sym.charAt(0));
                                        flag[2] = true;
                                    }
                                } else if (line.indexOf("G") == p_0) {
                                    for (String sym : syms) {
                                        G.add(sym.charAt(0));
                                        flag[3] = true;
                                    }
                                }
                            }
                        } else if (line.indexOf("q") == p_0 && line.indexOf("0") == (p_0 + 1)) {
                            q = line.substring(p_0 + 5, line.length());
                            flag[4] = true;
                        } else if (line.indexOf("B") == p_0) {
                            if (line.charAt(p_0+4)=='_'){
                                B = line.charAt(p_0 + 4);
                                flag[5] = true;
                            }
                        } else if (line.indexOf("N") == p_0) {
                            String ch = line.substring(p_0 + 4, line.length());
                            tapeNum = Integer.parseInt(ch);
                            flag[6] = true;
                        } else if (line.indexOf("D") == p_0) {
                            if (_flag){
                                //Q的初始化
                                for (String state : Q) {
                                    State temp = new State(state);
                                    temp.setQ(state);
                                    this.Q.put(state, temp);
                                    _flag=false;
                                }
                            }
                            if (line.indexOf("\r") != -1) {
                                String str = line.substring(p_0 + 2, line.length() - 1);
                                if (str.split(" ").length == 5) {
                                    TransitionFunction del = new TransitionFunction(str,this.Q);
                                    Delta.add(del);
                                    count++;
                                    flag[7] = true;
                                }
                            } else {
                                String str = line.substring(p_0 + 2, line.length());
                                if (str.split(" ").length == 5) {
                                    TransitionFunction del = new TransitionFunction(str,this.Q);
                                    Delta.add(del);
                                    count++;
                                    flag[7] = true;
                                }
                            }
                        } else if (true) {
                            System.err.println("Error: " + (i + 1));
                        }
                    } else if (line.indexOf(";") == -1) {
                        System.err.println("Error: " + (i + 1));
                    }
                }while (line.substring(p_0).indexOf("#")!=-1);
            }
        }
        if (flag[0]==false){
            System.err.println("Error: lack Q");
        }if (flag[1]==false){
            System.err.println("Error: lack F");
        }if (flag[2]==false){
            System.err.println("Error: lack S");
        }if (flag[3]==false){
            System.err.println("Error: lack G");
        }if (flag[4]==false){
            System.err.println("Error: lack q0");
        }if (flag[5]==false){
            System.err.println("Error: lack B");
        }if (flag[6]==false){
            System.err.println("Error: lack N");
        }if (flag[7]==false||count==0){
            System.err.println("Error: lack D");
        }
        //初始化
        this.S = S;
        this.G = G;
        this.F = F;
        this.B = B;
        this.q0 = q;
        this.tapeNum = tapeNum;
        for (TransitionFunction t : Delta) {
            this.Q.get(t.getSourceState().getQ()).addTransitionFunction(t);
        }
        int F_length=F.size(),S_length=S.size();
        Set<String> _F=new HashSet<>();
        Set<Character> _S=new HashSet<>();
        _F.addAll(F);
        _S.addAll(S);
        _F.retainAll(Q);
        if (_F.size()!=F_length) System.err.println("Error: 3");
        if (S.contains(B)) System.err.println("Error: 4");
        if (!G.contains(B)) System.err.println("Error: 5");
        _S.retainAll(G);
        if (_S.size()!=S_length) System.err.println("Error: 6");
        int e_count=0;
        for (TransitionFunction t: Delta){

            if ((t.getSourceState()==null)||(t.getDestinationState())==null){System.err.println("Error: 7");}
            for (char c:t.getInput().toCharArray()){
                if (!G.contains(c)) System.err.println("Error: 8");
            }
            for (char c:t.getOutput().toCharArray()){
                if (!G.contains(c)) System.err.println("Error: 8");
            }
            if (t.getSourceState()!=null&&t.getDestinationState()!=null) {
                for (TransitionFunction _t : Delta) {
                    if (t.getSourceState().equals(_t.getSourceState()) &&
                            t.getInput().equals(_t.getInput())) {
                        if (!(t.getOutput().equals(_t.getOutput()) &&
                                t.getDestinationState().equals(_t.getDestinationState()) &&
                                t.getDirection().equals(_t.getDirection()))) {
                            e_count++;
                        }
                    }
                }
            }
        }
        for (int i=0;i<e_count/2;i++)
            System.err.println("Error: 9");
    }

    public State getInitState() {
        return Q.get(q0);
    }

    /**
     * TODO
     * 停止的两个条件 1. 到了终止态 2. 无路可走，halts
     *
     * @param q Z
     * @return
     */
    public boolean isStop(State q, String Z) {
        if (this.F.contains(q)){
            return true;
        }
        if (q.isContainKey(Z)){
            return false;
        }else return true;
    }

    public boolean checkTape(Set<Character> tape) {
        int length_0=tape.size();
        if (tape.contains(B)) {
            tape.retainAll(this.S);
            if (length_0 == tape.size() + 1) {
                return true;
            } else {
                return false;
            }
        }else {
            tape.retainAll(this.S);
            if (length_0 == tape.size()) {
                return true;
            } else {
                return false;
            }
        }
    }

    public boolean checkTapeNum(int tapeNum) {
        if (this.tapeNum==tapeNum){
            return true;
        }else {
            return false;
        }
    }

    public Character getB() {
        return B;
    }


    /**
     * TODO
     * 检查迁移函数是否符合要求
     * @param s
     * @param lineno
     */
    private void resolverTransitionFunction(String s, int lineno) {

    }


    /**
     * TODO
     * is done in lab1 ~
     *
     * @return
     */
    @Override
    public String toString() {
        String str="";
        int count=1;
        str+="#Q = {";
        Set<String> keyQ=Q.keySet();
        for (String s:keyQ){
            if (count==Q.size()){
                str+=s+"}"+System.lineSeparator();
            }else {
                str+=s+",";
            }
            count++;
        }
        count=1;
        str+="#S = {";
        for (char ch:S){
            if (count==S.size()){
                str+=ch+"}"+System.lineSeparator();
            }else {
                str+=ch+",";
            }
            count++;
        }
        count=1;
        str+="#G = {";
        for (char ch:G){
            if (count==G.size()){
                str+=ch+"}"+System.lineSeparator();
            }else {
                str+=ch+",";
            }
            count++;
        }
        str+="#N = "+tapeNum+System.lineSeparator();
        count=1;
        str+="#F = {";
        for (String s:F){
            if (count==F.size()){
                str+=s+"}"+System.lineSeparator();
            }else {
                str+=s+",";
            }
            count++;
        }
        str+="#B = "+B+System.lineSeparator();
        str+="#q0 = "+q0+System.lineSeparator();

        Collection<State> valueQ=Q.values();
        for (State q:valueQ){
            Collection<TransitionFunction> del_s=q.getDeltas();
            for (TransitionFunction del:del_s){
                str+=del.toString();
            }
        }
        int len=str.length();
        str=str.substring(0,len-1);
        return str;
    }

    public State purpose_Q(String str){
        try {
            State purpose=this.Q.get(str);
            return purpose;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
