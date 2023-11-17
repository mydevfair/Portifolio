package Practical_11;

import java.util.Arrays;
import java.util.Comparator;

public class Session {
    int sessionId;
    int capacity = 4;
    int currentSize = 0;
    String location;
    Talk[] talkList;

    public Session(int sessionId, String location) {
        this.sessionId = sessionId;
        this.location = location;
        this.talkList = new Talk[capacity];
    }

    public void scheduleTalk(Talk talk) {
        for (int i = 0; i < talkList.length; i++) {
            if (talkList[i] == null) {
                talkList[i] = talk;
                Arrays.sort(talkList, Comparator.nullsFirst(Comparator.naturalOrder()));
                currentSize++;
                break;
            }
        }
    }

    public void cancelTalk(Talk talk) {
        for (int i = 0; i < talkList.length; i++) {
            if (talkList[i].id == talk.id) {
                talkList[i] = null;
                Arrays.sort(talkList, Comparator.nullsLast(Comparator.naturalOrder()));
                currentSize--;
                break;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Session{" +
                "sessionId=" + sessionId +
                ", capacity=" + capacity +
                ", currentSize=" + currentSize +
                ", location='" + location + '\'' +
                ", talkList=[\n");

        for (int i = 0; i < talkList.length; i++) {
            if (talkList[i] != null) {
                result.append("\t").append(talkList[i]).append("\n");
            }
        }

        result.append("]}");

        return result.toString();
    }
}
