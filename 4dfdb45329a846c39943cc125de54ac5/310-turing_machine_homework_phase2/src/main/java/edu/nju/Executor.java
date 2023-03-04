package edu.nju;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author: pkun
 * @CreateTime: 2021-05-25 23:53
 */
public class Executor {

    ArrayList<Tape> tapes;
    TuringMachine tm;
    State q;
    int steps = 0;
    boolean canRun = true;

    public Executor(TuringMachine tm, ArrayList<Tape> tapes) {
        this.tm = tm;
        this.q = tm.getInitState();
        loadTape(tapes);
    }

    /**
     * TODO
     * 1. 检查能否运行
     * 2. 调用tm.delta
     * 3. 更新磁带
     * 4. 返回下次能否执行
     *
     * @return
     */
    public Boolean execute() {
        String newTapes = "";
        int head;
        String input = "";
        for (Tape tape: tapes){
            head = tape.getHead();
            for (StringBuilder track: tape.tracks){
                input += track.charAt(head);
            }
        }

        if (!tm.isStop(q, input)){
            //得到delta函数
            TransitionFunction delta = q.getDelta(input);
            String outPut=delta.getOutput();
            String direction= delta.getDirection();
            State destinationState=delta.getDestinationState();
            int cnt = 0;

            //更改磁带和磁头
            for (Tape tape: tapes){
                head = tape.getHead();
                for (StringBuilder track: tape.tracks){
                    track.setCharAt(head, outPut.charAt(cnt));
                    cnt++;
                    newTapes += track + ",";
                }
                newTapes = newTapes.substring(0, newTapes.length() - 1);
                newTapes += "\n";
            }
            newTapes = newTapes.substring(0, newTapes.length() - 1);
            this.updateTape(newTapes);
            this.moveHeads(direction);

            //更新状态
            q = tm.purpose_Q(destinationState.getQ());
            this.steps++;
            input = "";
            for (Tape tape:tapes) {
                head = tape.getHead();
                for (StringBuilder track: tape.tracks) {
                    input += track.charAt(head);
                }
            }
            if (tm.isStop(q, input)) return false;
            return true;
        }

        return false;
    }

    /**
     * TODO
     * 1. 检查磁带的数量是否正确 ( checkTapeNum )
     * 2. 检查磁带上的字符是否是输入符号组的 ( checkTape )
     *
     * @param tapes
     */
    public void loadTape(ArrayList<Tape> tapes) {
        if (!tm.checkTapeNum(tapes.size())) System.err.println("Error: 2");

        for (Tape tape: tapes){
            Set<Character> setTape=new HashSet<Character>();
            for (StringBuilder track: tape.tracks){
                char[] words = track.toString().toCharArray();
                for (char word: words) setTape.add(word);
            }
            if (!tm.checkTape(setTape)) System.err.println("Error: 1");
        }

        this.tapes = tapes;
    }

    /**
     * TODO
     * 获取所有磁带的快照，也就是把每个磁带上磁头指向的字符全都收集起来
     *
     * @return
     */
    private String snapShotTape() {
        String result = "";
        for (int i = 0; i < tapes.size(); i++){
            result += "Tape" + i + " :" + System.lineSeparator() + "Index" + i + ":";
            result += tapes.get(i).snapShot();
            result += "Head" +i + " : " + tapes.get(i).getHead() + System.lineSeparator();
        }
        return result;
    }

    /**
     * TODO
     * 按照README给出当前图灵机和磁带的快照
     *
     * @return
     */
    public String snapShot() {
        String result = "";
        result+="Step  : "+this.steps+System.lineSeparator();

        result += this.snapShotTape();

        result += "State : " + q.getQ() + System.lineSeparator();
        return result;
    }


    /**
     * TODO
     * 不断切割newTapes，传递给每个Tape的updateTape方法
     *
     * @param newTapes
     */
    private void updateTape(String newTapes) {
        String[] myTape = newTapes.split("\n");
        for (int i = 0; i < myTape.length; i++){
            tapes.get(i).updateTape(myTape[i]);
        }
    }

    /**
     * TODO
     * 将每个direction里的char都分配给Tape的updateHead方法
     *
     * @param direction
     */
    private void moveHeads(String direction) {
        for (int i = 0; i < direction.length(); i++){
            tapes.get(i).updateHead(direction.charAt(i));
        }
    }



}
