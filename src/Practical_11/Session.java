/**
 * Class: Session
 * Description: Represents a session in the conference. Manages scheduling and cancellation of talks.
 */
package Practical_11;

import java.util.Arrays;
import java.util.Comparator;

public class Session {
    /**
     * A class representing a Session
     */
    int sessionId, capacity = 4, currentSize = 0;
    String location;
    Talk[] talkList;
    /**
     * Constructor to initialize Session object with provided values
     * @param sessionId The id of the session
     * @param location The location of the session
     */
    public Session(int sessionId, String location) {
        this.sessionId = sessionId;
        this.location = location;
        this.talkList = new Talk[capacity];
    }
    /**
     * Method to schedule a talk
     * @param talk The talk to be scheduled
     */
    public void scheduleTalk(Talk talk) {
        for (int i = 0; i < talkList.length; i++) {
            if (talkList[i] == null) {
                talkList[i] = talk;
                Arrays.sort(talkList, Comparator.nullsLast(Comparator.naturalOrder()));
                currentSize++;
                break;
            }
        }
    }
    /**
     * Method to cancel a talk
     * @param talk The talk to be cancelled
     */
    public void cancelTalk(Talk talk) {
        for (int i = 0; i < talkList.length; i++) { // Loop through talkList
            if (talkList[i].id == talk.id) {// If talkList[i] is equal to talk
                talkList[i] = null;// Set talkList[i] to null
                Arrays.sort(talkList, Comparator.nullsLast(Comparator.naturalOrder())); // Sort talkList
                currentSize--; // Decrement currentSize
                break; // Break out of loop
            }
        }
    }
    /**
     * Method to print the talks in the session
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Session{" +
                "sessionId=" + sessionId +
                ", capacity=" + capacity +
                ", currentSize=" + currentSize +
                ", location='" + location + '\'' +
                ", talkList=[\n");

        for (int i = 0; i < talkList.length; i++) {
            if (talkList[i] != null) {
                result.append("\t").append(talkList[i]).append("\n");
            }
        }

        result.append("]}");

        return result.toString();
    }
}
