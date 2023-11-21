/*
 * File: PublicationSystem.java
 * Author: Chris Fairhurst
 * Date: November 19, 2023
 * Description: This file contains the implementation of a research publication system, based on Java’s LinkedList.
 *              It includes classes for Reviews, Papers, and a main method in the PublicationSystem class for testing.
 */
package Practical_12;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;

public class PublicationSystem {
    /**
     * Assigns the Best Paper Award to the paper with the highest weighted average score.
     * @param papers List of papers to be considered for the award.
     */
    public static void assignBestPaperAward(List<Paper> papers) {
        if (papers.isEmpty()) {
            System.out.println("No papers available. Cannot assign Best Paper Award.");
            return;
        }
        Paper bestPaper = null;
        double highestWeightedAverage = -1;

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
                    System.out.println("Paper " + paper.getId() + ": Avg: " + new DecimalFormat("#.##").format(weightedAverage));

                    if (weightedAverage > highestWeightedAverage) {
                        highestWeightedAverage = weightedAverage;
                        bestPaper = paper;
                    }
                }
            }
        }
        if (bestPaper != null) {
            BigDecimal bd = new BigDecimal(highestWeightedAverage);
            System.out.println("Best Paper Award assigned to Paper " + bestPaper.getId() +
                    ": Avg: " + new DecimalFormat("#.##").format(bd.doubleValue()));
        } else {
            System.out.println("No eligible papers for Best Paper Award.");
        }
    }
    /**
     * Main method for testing the PublicationSystem.
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        /**
         * Creates three papers
         */
        Paper paper1 = new Paper(1, "Title1", "Author1");
        Paper paper2 = new Paper(2, "Title2", "Author2");
        Paper paper3 = new Paper(3, "Title3", "Author3");
        /**
         * Creates four reviews
         */
        Review review1 = new Review(1, "Reviewer A", 5, 4, "Good");
        Review review2 = new Review(2, "Reviewer B", 9, 2, "Average");
        Review review3 = new Review(3, "Reviewer A", 5, 4, "Good");
        Review review4 = new Review(4, "Reviewer B", 9, 2, "Average");
        /**
         * Submits, updates, and deletes reviews for each paper
         */
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
        /**
         * Creates a list of papers and assigns the Best Paper Award
         */
        List<Paper> papers = List.of(paper1, paper2, paper3);

        /**
         * Assigns the Best Paper Award to the paper with the highest weighted average score.
         * @param papers List of papers to be considered for the award.
         */
        assignBestPaperAward(papers);
    }
}