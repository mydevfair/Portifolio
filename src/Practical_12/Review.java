package Practical_12;

public class Review implements Comparable<Review>{
    private Integer id, score, confidence;
    private String reviewer, summary;

    public Review(Integer id, Integer score, Integer confidence, String reviewer, String summary) {
        this.id = id;
        this.score = score;
        this.confidence = confidence;
        this.reviewer = reviewer;
        this.summary = summary;
    }

    public Integer getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", score=" + score +
                ", confidence=" + confidence +
                ", reviewer='" + reviewer + '\'' +
                ", summary='" + summary + '\'' +
                '}';
    }
    @Override
    public int compareTo(Review o) {
        return this.score.compareTo(o.score);
    }
}
