/**
 * Class to represent a Paper
 * Description: Represents a paper in the conference.
 */
package Practical_12;

import java.util.Collections;
import java.util.LinkedList;
/**
 * A class representing a Paper
 */
public class Paper {
    // Properties of a Paper
    private int id;
    String title, authors;
    LinkedList<Review> reviewList;

    /**
     * Constructor to initialize Paper object with provided values
     *
     * @param id      The id of the paper
     * @param title   The title of the paper
     * @param authors The authors of the paper
     */

    public Paper(int id, String title, String authors) {
        this.id = id;
        this.title = title;
        this.authors = authors;
        this.reviewList = new LinkedList<>();
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public LinkedList<Review> getReviewList() {
        return reviewList;
    }

    /**
     * Method to submit a review for the paper
     *
     * @param review The review to be submitted
     */
    public void submitReview(Review review) {
        if (!reviewList.contains(review)) {
            reviewList.add(review);
            Collections.sort(reviewList);
            System.out.println("Review submitted for Paper " + id + ": " + review);
            printReviewList();
            printPaper();
        } else {
            System.out.println("Reviewer " + review.getReviewer() + " already submitted a review for Paper " + id);
        }
    }

    /**
     * Method to delete a review for the paper
     *
     * @param review The review to be deleted
     */
    public void deleteReview(Review review) {
        if (reviewList.contains(review)) {
            reviewList.remove(review);
            Collections.sort(reviewList);
            System.out.println("Review removed for Paper " + id + ": " + review);
            printReviewList();
            printPaper();
        } else {
            System.out.println("Reviewer " + review.getReviewer() + " has not submitted a review for this paper " + id);
        }
    }

    /**
     * Method to update a review for the paper
     *
     * @param review     The review to be updated
     * @param reviewer   The reviewer of the review
     * @param score      The score of the review
     * @param confidence The confidence of the review
     * @param summary    The summary of the review
     */
    public void updateReview(Review review, String reviewer, Integer score, Integer confidence, String summary) {
        if (reviewList.contains(review)) {
            review.setReviewer(reviewer);
            review.setScore(score);
            review.setConfidence(confidence);
            review.setSummary(summary);
            Collections.sort(reviewList);
            System.out.println("Review updated for Paper " + id + ": " + review);
            printPaper();
        }
    }

    /**
     * Method to print the review list for the paper
     *
     * @return
     */
    public String printReviewList() {
        System.out.println("Review List for Paper " + id + ": ");
        for (Review review : reviewList) {
            return review.toString();
        }
        return null;
    }
        /**
         * Method to print the details of the paper
         */
        public void printPaper () {
            System.out.println("Talk Paper Id= " + id + "\nPaper Title= " + title + "\nPaper Author= " + authors);
            for (Review review : reviewList) {
                System.out.println(review.toString());
            }
        }
    }

