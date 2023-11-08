public class Talk implements Comparable<Talk>{
    private String id, speaker, title, startTime;

    public Talk(String id, String speaker, String title, String startTime) {
        this.id = id;
        this.speaker = speaker;
        this.title = title;
        this.startTime = startTime;
    }



    @Override
    public String toString() {
        return "\nTalk{" +
                "id='" + id + '\'' +
                ", speaker='" + speaker + '\'' +
                ", title='" + title + '\'' +
                ", startTime='" + startTime + '\'' +
                '}' ;
    }

    @Override
    public int compareTo(Talk o) {
        return this.startTime.compareTo(o.startTime);
    }
}