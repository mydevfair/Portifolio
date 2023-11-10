package Practical_11;

import java.util.Arrays;
import java.util.Objects;

public class Session {
    private String sessionId, location;
    private Talk [] talkList;

    private int entryCount;
    private int capacity = 4;
//    private int currentSize;

    public Session(String sessionId, String location) {
        this.sessionId = sessionId;
        this.location = location;
        this.talkList = new Talk[capacity];
    }
    public void scheduleTalk(Talk talk) {
        for (int i = 0; i < talkList.length; i++) {
            if (talkList[i] == null) {
                talkList[i] = talk;
                entryCount += 1;
                break;
            }
        }
    }
//    public void print(){
//            for (int i = 0; i < entryCount; i++){
//                System.out.println();
//            }
//        }
    public void cancelTalk(Talk talk){
        for (int i = 0; i < talkList.length; i++){
            if (Objects.equals(talkList[i].getId(), talk.getId())){
                swap(talkList, i, talkList.length -1);
                talkList[talkList.length-1] = null;
                break;
            }
        }
    }
    public static void swap(Talk[] array, int from, int to){
        Talk tmp = array[from];
        array[from] = array[to];
        array[to] = tmp;
    }

    @Override
    public String toString() {
        return "Session{" +
                "id='" + sessionId + '\'' +
                ", location='" + location + '\'' +
                "\ntalkList=" + Arrays.toString(talkList) +
                '}';
    }
}
