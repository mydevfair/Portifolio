/**
 * Class: Review
 * Description: Represents a review for a paper in the conference.
 * Implements Comparable for sorting based on score.
 */
package Practical_12;
/**
 * A class representing a Review
 */
public class Review implements Comparable<Review> {
    Integer id, score, confidence;
    String reviewer, summary;

    /**
     * Constructor to initialize Review object with provided values
     *
     * @param id         The id of the review
     * @param reviewer   The reviewer of the review
     * @param score      The score of the review
     * @param confidence The confidence of the review
     * @param summary    The summary of the review
     */
    public Review(Integer id, String reviewer, Integer score, Integer confidence, String summary) {
        this.id = id;
        this.score = score;
        this.confidence = confidence;
        this.reviewer = reviewer;
        this.summary = summary;
    }

    // Getters and Setters
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

    /**
     * Method to print the details of the review
     */
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
    /**
     * Method to check if two Review objects are equal
     *
     * @param o The Review object to be compared with
     * @return true if the two Review objects are equal, false otherwise
     */
    @Override
    public int compareTo(Review o) {
        return -this.score.compareTo(o.score);
    }
}
