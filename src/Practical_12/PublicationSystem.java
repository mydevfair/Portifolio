package Practical_12;

import java.util.LinkedList;
import java.util.List;

public class PublicationSystem {
    public static void main(String[] args) {
        LinkedList<Paper> papers = new LinkedList<>();
        LinkedList<Review> reviews = new LinkedList<>();

        Paper paper1 = new Paper<>(1, "Title", "Author");
        Review review1 = new Review(1, 10, 5, "reviwer", "Summary");

        papers.add(paper1);
        reviews.add(review1);
        papers.add(review1);

    }
}
