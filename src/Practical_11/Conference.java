package Practical_11;

public class Conference {
    public static void main(String[] args) {
        Talk talk1 = new Talk("1", "Speaker 1", "1", "2020-07-10 15:10:00.000");
        Talk talk2 = new Talk("2", "Speaker 2", "2", "2020-07-10 09:00:00.000");
        Talk talk3 = new Talk("3", "Speaker 3", "3", "2020-07-10 10:00:00.000");
        Talk talk4 = new Talk("4", "Speaker 3", "3", "2020-07-10 16:00:00.000");
        Session session1 = new Session(1, "Location1");

        session1.scheduleTalk(talk1);
        session1.scheduleTalk(talk2);
        session1.scheduleTalk(talk3);
        session1.scheduleTalk(talk4);
        session1.printSession();
        session1.cancelTalk(talk2);
        session1.printSession();
    }
}
