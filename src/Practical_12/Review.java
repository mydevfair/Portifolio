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
        this.score = setScore(score);
        this.confidence = setConfidence(confidence);
        this.reviewer = reviewer;
        this.summary = summary;
    }

    /**
     * Method to get the id of the review
     *
     * @return The id of the review
     */
    public Integer getScore() {
        return score;
    }
    /**
     * Method to get the id of the review
     *
     * @return The id of the review
     */
    public Integer getConfidence() {
        return confidence;
    }
    /**
     * Method to get the id of the review
     *
     * @return The id of the review
     */
    public String getReviewer() {
        return reviewer;
    }
    /**
     * Method to set the score of the review
     *
     * @param score The score of the review
     */
    public Integer setScore(Integer score) {
        if (score < 0 || score > 10) {
            System.out.println("Invalid score. Score must be between 0 and 10 confidence has been set to null please update to change..");
            return null;
        }
        return this.score = score;
    }
    /**
     * Method to set the confidence of the review
     *
     * @param confidence The confidence of the review
     */
    public Integer setConfidence(Integer confidence) {
        if (confidence < 0 || confidence > 5) {
            System.out.println("Invalid confidence. Confidence must be between 0 and 5 score has been set to null please update to change.");
            return null;
        }
        return this.confidence = confidence;
    }
    /**
     * Method to set the reviewer of the review
     *
     * @param reviewer The reviewer of the review
     */
    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }
    /**
     * Method to set the summary of the review
     *
     * @param summary The summary of the review
     */
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
