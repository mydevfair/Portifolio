package Practical_12;

public class Review implements Comparable<Review> {

    Integer id, score, confidence;

    String reviewer, summary;

    public Review(int id, String reviewer, int score, int confidence, String summary){
        this.id = id;
        this.reviewer = reviewer;
        this.score = score;
        this.confidence = confidence;
        this.summary = summary;
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
