package Practical_11;

public class Talk implements Comparable<Talk>{
    String id, speaker, title, startTime;

    public Talk(String id, String speaker, String title, String startTime) {
        this.id = id;
        this.speaker = speaker;
        this.title = title;
        this.startTime = startTime;
    }

    @Override
    public String toString() {
        return "Talk{" +
                "id='" + id + '\'' +
                ", speaker='" + speaker + '\'' +
                ", title='" + title + '\'' +
                ", startTime='" + startTime + '\'' +
                '}';
    }

    @Override
    public int compareTo(Talk o) {
        return this.startTime.compareTo(o.startTime);
    }
}
