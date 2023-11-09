import java.util.Arrays;
import java.util.Comparator;

public class Session {
    private String sessionId, location;
    private Talk [] talkList;
//    private int currentSize;

    public Session(String sessionId, String location) {
        final int capacity = 4;
        this.sessionId = sessionId;
        this.location = location;
        this.talkList = new Talk[4];
    }
    public void scheduleTalk(Talk talk) {
        for (int i = 0; i < talkList.length; i++) {
            if (talkList[i] == null) {
                talkList[i] = talk;
                break;
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
