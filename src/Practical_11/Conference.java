/*
 * File: Conference.java
 * Author: Chris Fairhurst
 * Date: November 19, 2023
 * Description: This file contains the implementation of a conference scheduling system.
 *              It includes classes for Talks, Sessions, and a main method in the Conference class for testing.
 */

package Practical_11;

public class Conference {
    /**
     * Method to print the conference schedule
     * @param sessions The sessions in the conference
     */
    public static void printConferenceSchedule(Session[] sessions) {
        System.out.println("Conference Schedule: ");
        for (Session session : sessions) {
            System.out.println(session);
        }
    }
    public static void main(String[] args) {
        /**
         * Create 16 Talk objects
         */
        Talk talk1 = new Talk("1", "Speaker 1", "1", "2020-07-10 00:00:00.000");
        Talk talk2 = new Talk("2", "Speaker 2", "2", "2021-07-10 01:00:00.000");
        Talk talk3 = new Talk("3", "Speaker 3", "3", "2022-07-10 02:00:00.000");
        Talk talk4 = new Talk("4", "Speaker 4", "4", "2023-07-10 03:00:00.000");
        Talk talk5 = new Talk("5", "Speaker 5", "5", "2024-07-10 04:00:00.000");
        Talk talk6 = new Talk("6", "Speaker 6", "6", "2025-07-10 05:00:00.000");
        Talk talk7 = new Talk("7", "Speaker 7", "7", "2026-07-10 06:00:00.000");
        Talk talk8 = new Talk("8", "Speaker 8", "8", "2027-07-10 07:00:00.000");
        Talk talk9 = new Talk("9", "Speaker 9", "9", "2028-07-10 08:00:00.000");
        Talk talk10 = new Talk("10", "Speaker 10", "10", "2029-07-10 09:00:00.000");
        Talk talk11 = new Talk("11", "Speaker 11", "11", "2030-07-10 10:00:00.000");
        Talk talk12 = new Talk("12", "Speaker 12", "12", "2031-07-10 11:00:00.000");
        Talk talk13 = new Talk("13", "Speaker 13", "13", "2032-07-10 12:00:00.000");
        Talk talk14 = new Talk("14", "Speaker 14", "14", "2033-07-10 13:00:00.000");
        Talk talk15 = new Talk("15", "Speaker 15", "15", "2034-07-10 14:00:00.000");
        Talk talk16 = new Talk("16", "Speaker 16", "16", "2035-07-10 15:00:00.000");

        /**
         * Create 4 Session objects
         */
        Session session1 = new Session(1, "Location 1");
        Session session2 = new Session(2, "Location 2");
        Session session3 = new Session(3, "Location 3");
        Session session4 = new Session(4, "Location 4");

        /**
         * Schedule and cancel talks in each session
         */
        session1.scheduleTalk(talk1);
        session1.scheduleTalk(talk2);
        session1.scheduleTalk(talk3);
        session1.scheduleTalk(talk4);
        System.out.println("Session 1:" + session1);
        session1.cancelTalk(talk4);
        System.out.println("Session 1:" + session1);

        session2.scheduleTalk(talk5);
        session2.scheduleTalk(talk6);
        session2.scheduleTalk(talk7);
        session2.scheduleTalk(talk8);
        System.out.println("Session 2:" + session2);
        session2.cancelTalk(talk8);
        System.out.println("Session 2:" + session2);

        session3.scheduleTalk(talk9);
        session3.scheduleTalk(talk10);
        session3.scheduleTalk(talk11);
        session3.scheduleTalk(talk12);
        System.out.println("Session 3: " + session3);
        session3.cancelTalk(talk12);
        System.out.println("Session 3: " + session3);

        session4.scheduleTalk(talk13);
        session4.scheduleTalk(talk14);
        session4.scheduleTalk(talk15);
        session4.scheduleTalk(talk16);
        System.out.println("Session 4:" + session4);
        session4.cancelTalk(talk16);
        System.out.println("Session 4:" + session4);

        printConferenceSchedule(new Session[]{session1, session2, session3, session4});
    }
}
