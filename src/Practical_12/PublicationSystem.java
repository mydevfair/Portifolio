package Practical_12;

import java.util.List;

public class PublicationSystem {
    public static void assignBestPaperAward(List<Paper> papers) {
        if (papers.isEmpty()) {
            System.out.println("No papers available. Cannot assign Best Paper Award.");
            return;
        }
        Paper bestPaper = null;
        double highestWeightedAverage = -1; // Initialize to a value that ensures any valid score will be higher

        for (Paper paper : papers) {
            if (!paper.getReviewList().isEmpty()) {
                double weightedSum = 0;
                int totalConfidence = 0;

                for (Review review : paper.getReviewList()) {
                    weightedSum += review.getScore() * review.getConfidence();
                    totalConfidence += review.getConfidence();
                }

                if (totalConfidence > 0) {
                    double weightedAverage = weightedSum / totalConfidence;

                    if (weightedAverage > highestWeightedAverage) {
                        highestWeightedAverage = weightedAverage;
                        bestPaper = paper;
                    }
                }
            }
        }
        if (bestPaper != null) {
            System.out.println("Best Paper Award assigned to Paper " + bestPaper.getId());
        } else {
            System.out.println("No eligible papers for Best Paper Award.");
        }
    }

    public static void main(String[] args) {

        Paper paper1 = new Paper(1, "Title1", "Author1");
        Paper paper2 = new Paper(2, "Title2", "Author2");
        Paper paper3 = new Paper(3, "Title3", "Author3");

        Review review1 = new Review(1, "Reviewer A", 5, 4, "Good");
        Review review2 = new Review(2, "Reviewer B", 9, 2, "Average");
        Review review3 = new Review(3, "Reviewer A", 5, 4, "Good");
        Review review4 = new Review(4, "Reviewer B", 9, 2, "Average");

        paper1.submitReview(review1);
        paper1.submitReview(review2);
        paper1.submitReview(review3);
        paper1.updateReview(review1, "Reviewer A", 10, 6, "Awesome");
        paper1.deleteReview(review2);
        paper1.printPaper();

        paper2.submitReview(review1);
        paper2.submitReview(review2);
        paper2.submitReview(review3);
        paper2.updateReview(review1, "Reviewer A", 10, 6, "Awesome");
        paper2.deleteReview(review2);
        paper2.printPaper();

        paper3.submitReview(review1);
        paper3.submitReview(review2);
        paper3.submitReview(review3);
        paper3.submitReview(review4);
        paper3.updateReview(review1, "Reviewer A", 10, 6, "Awesome");
        paper3.deleteReview(review2);
        paper3.printPaper();

        List<Paper> papers = List.of(paper1, paper2, paper3);

        // Assuming reviews are already submitted for each paper
        assignBestPaperAward(papers);
    }
}