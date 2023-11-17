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

    public Integer getScore() {
        return score;
    }

    public Integer getConfidence() {
        return confidence;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public void setConfidence(Integer confidence) {
        this.confidence = confidence;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Review{" +
                "id=" + id +
                ", score=" + score +
                ", confidence=" + confidence +
                ", reviewer='" + reviewer + '\'' +
                ", summary='" + summary + '\'' +
                '}' + "\n");

        return result.toString();
    }
    @Override
    public int compareTo(Review o) {
        return -this.score.compareTo(o.score);
    }
}
