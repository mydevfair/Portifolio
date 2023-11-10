package Practical_11;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

public class Session {
    private String sessionId, location;
    private Talk [] talkList;

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
                break;
            }
        }
    }
    public void cancelTalk(Talk talk){
        for (int i = 0; i < talkList.length; i++){
            if (Objects.equals(talkList[i].getId(), talk.getId())){
                talkList[i] = null;

            }
        }
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
