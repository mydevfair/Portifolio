package Practical_12;

import java.util.Collections;
import java.util.LinkedList;

public class Paper {
    private int id;
    String title, authors;
    LinkedList<Review> reviewList;

    public Paper(int id, String title, String authors) {
        this.id = id;
        this.title = title;
        this.authors = authors;
        this.reviewList = new LinkedList<>();
    }

    public void submitReview(Review review) {
        if (!reviewList.contains(review)){
            reviewList.add(review);
            Collections.sort(reviewList);
            System.out.println("Review submitted for Paper " + id + ": " + review);
            printReviewList();
        }else {
            System.out.println("Reviewer " + review.getReviewer() + " already submitted a review for Paper " + id);
        }
    }
    public void deleteReview(Review review) {
        if (reviewList.contains(review)){
            reviewList.remove(review);
            Collections.sort(reviewList);
            System.out.println("Review removed for Paper " + id + ": " + review);
            printReviewList();
        }else {
            System.out.println("Reviewer " + review.getReviewer() + " has not submitted a review for this paper " + id);
        }
    }
    public void updateReview(Review review, String reviewer, Integer score, Integer confidence, String summary){
        if (reviewList.contains(review)) {
            review.setReviewer(reviewer);
            review.setScore(score);
            review.setConfidence(confidence);
            review.setSummary(summary);
            Collections.sort(reviewList);
            System.out.println("Review updated for Paper " + id + ": " + review);
            printReviewList();
        }
    }
    public void printReviewList() {
        System.out.println("Review List for Paper " + id + ": ");
        for (Review review : reviewList) {
            System.out.println(review);
        }
    }
    public void printPaper(){
        System.out.println("Paper Id= " + id + "\nPaper Title= " + title + "\nPaper Author= " + authors);
        for (Review review : reviewList) {
            System.out.println(review);
        }
    }

    @Override
    public String toString() {
        return "Paper{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", authors='" + authors + '\'' +
                ",\n reviewList=\n" + reviewList +
                '}' + "\n";
    }
}
