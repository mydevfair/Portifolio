package Practical_12;

import java.util.LinkedList;
import java.util.List;

public class PublicationSystem {
    public static void main(String[] args) {

        Paper paper1 = new Paper(1, "Title1", "Author1");
        Paper paper2 = new Paper(2, "Title2", "Author2");
        Paper paper3 = new Paper(3, "Title3", "Author3");

        Review review1 = new Review(1, "Reviewer A", 5, 4, "Good");
        Review review2 = new Review(2, "Reviewer B", 9, 2, "Average");

        paper1.submitReview(review2);
        paper1.submitReview(review1);

        paper1.deleteReview(review1);


        System.out.println(paper1);

    }
}
