package Practical_12;

public class Review implements Comparable<Review> {
    Integer id, score, confidence;
    String reviewer, summary;

    public Review(Integer id, String reviewer, Integer score, Integer confidence, String summary) {
        this.id = id;
        this.score = score;
        this.confidence = confidence;
        this.reviewer = reviewer;
        this.summary = summary;
    }

    public String getReviewer() {
        return reviewer;
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
        return -this.score.compareTo(o.score);
    }
}
