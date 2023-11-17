package Practical_12;

public class PublicationSystem {
    //Assigns the ‘Best Paper Award’ by calculating the weighted average
    //score for each paper based on review score and confidence

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


        int confidence = 0;
        int weightedAverage =0;
        for (int i = 0; i < paper1.reviewList.size(); i++){
            int score = paper1.reviewList.element().getScore();
            System.out.println(score);
        }
    }
}
