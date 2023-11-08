import java.util.Arrays;

public class Session {
    private String sessionId, location;
    private String[] talkList;
//    private int currentSize;

    public String[] getTalkList() {
        return talkList;
    }

    public Session(String sessionId, String location) {
        final int capacity = 4;
        this.sessionId = sessionId;
        this.location = location;
        this.talkList = new String[capacity];

    }

    public void scheduleTalk(Talk talk){
        int currentSize = 0;
        for (int i = 0; i < talkList.length; i++){
            if (talkList[i] == null){
                talkList[i] = String.valueOf(talk);
                currentSize +=1;
                break;
            }
        }
    }

    public void cancelTalk(Talk talk){
        for (int i = 0; i < talkList.length; i++){
            if (talkList[i] == String.valueOf(talk)){
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
