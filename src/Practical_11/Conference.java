package Practical_11;

public class Conference {
    public static void main(String[] args) {
        Talk talk1 = new Talk("1", "Speaker 1", "Talk A", "2023-11-07T09:04:00");
        Talk talk2 = new Talk("2", "Speaker 2", "Talk B", "2023-11-07T10:02:00");
        Talk talk3 = new Talk("3", "Speaker 3", "Talk C", "2023-11-07T14:08:00");
        Talk talk4 = new Talk("4", "Speaker 4", "Talk D", "2023-11-07T15:06:00");
//        Talk talk5 = new Talk("5", "Speaker 5", "Talk A", "2023-11-07T09:04:00");
//        Talk talk6 = new Talk("6", "Speaker 6", "Talk B", "2023-11-07T10:02:00");
//        Talk talk7 = new Talk("7", "Speaker 7", "Talk C", "2023-11-07T14:08:00");
//        Talk talk8 = new Talk("8", "Speaker 8", "Talk D", "2023-11-07T15:06:00");

        Session session1 = new Session("1", "Leeds");
//        Session session2 = new Session("2", "Sheffield");

        session1.scheduleTalk(talk1);
        session1.scheduleTalk(talk2);
        session1.scheduleTalk(talk3);
        session1.scheduleTalk(talk4);

        System.out.println(session1);

        session1.cancelTalk(talk1);
        System.out.println(session1);

        session1.scheduleTalk(talk1);
        System.out.println(session1);
    }
}
