package Practical_11;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Talk implements Comparable<Talk>{
    private String id, speaker, title, startTime;


    public Talk(String id, String speaker, String title, String startTime) {
        this.id = id;
        this.speaker = speaker;
        this.title = title;
        this.startTime = startTime;
    }

    public String getId() {
        return id;
    }

    public String getSpeaker() {
        return speaker;
    }

    public String getTitle() {
        return title;
    }

    public String getStartTime() {
        return startTime;
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
        return this.getStartTime().compareTo(o.getStartTime());
    }
}