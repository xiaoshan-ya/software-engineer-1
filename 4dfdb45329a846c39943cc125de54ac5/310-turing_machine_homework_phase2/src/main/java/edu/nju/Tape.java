package edu.nju;

import java.util.ArrayList;

/**
 * @Author: pkun
 * @CreateTime: 2021-05-23 19:37
 */
public class Tape {

    ArrayList<StringBuilder> tracks;
    private final char B;
    private int head;

    public Tape(ArrayList<StringBuilder> tracks, int head, char B) {
        this.tracks = tracks;
        this.head = head;
        this.B = B;
    }

    public String snapShot() {
        int index_begin = this.head;
        int index_final = this.head;
        String result = "";
        StringBuilder track = tracks.get(0);
        for (int i = 0; i < track.length(); i++){
            if (track.charAt(i) != B) {
                index_begin = i;
                break;
            }

        }
        for (int i = track.length() - 1; i > -1; i--){
            if (track.charAt(i) != B) {
                index_final = i;
                break;
            }

        }

        if (track.charAt(head) == B){
            if (head < index_begin) index_begin=head;
            if (head > index_final) index_final=head;
        }

        for (int i = index_begin; i <= index_final; i++){
            result += " " + i;
        }
        result += System.lineSeparator();

        for (int i = 0; i < tracks.size(); i++){
            result += "Track" + i + ":";
            for (int j = index_begin; j <= index_final; j++){
                if (j < 10 || j == index_final) result += " " + tracks.get(i).charAt(j);
                else{
                    result += " " + tracks.get(i).charAt(j) + " ";
                }
            }
            result += System.lineSeparator();
        }

        return result;
    }

    public void updateHead(char c) {
        if (c == 'l') this.head--;
        if (c == 'r') this.head++;

        for (int i = 0; i < tracks.size(); i++){
            if (head == -1) tracks.get(i).insert(0, B);

            if (head == tracks.get(i).length()){
                for (int j = 0; j < tracks.size(); j++){
                    tracks.get(j).append(B);
                }
                break;
            }
        }
    }


    public void updateTape(String newTape) {
        String[] newTapes = newTape.split(",");
        for (int i=0;i<newTapes.length;i++){
            this.tracks.set(i,new StringBuilder(newTapes[i]));
        }
    }

    public int getHead() { return this.head; }
}
