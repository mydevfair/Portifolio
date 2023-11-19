/**
 * Class: Conference
 * Description: Contains the main method for testing the conference scheduling functionality.
 */

package Practical_11;
/**
 * A class representing a Talk
 */
public class Talk implements Comparable<Talk> {
    // Properties of a Talk
    String id, speaker, title, startTime;

    /**
     * Constructor to initialize Talk object with provided values
     *
     * @param id        The id of the talk
     * @param speaker   The speaker of the talk
     * @param title     The title of the talk
     * @param startTime The start time of the talk
     */
    public Talk(String id, String speaker, String title, String startTime) {
        this.id = id;
        this.speaker = speaker;
        this.title = title;
        this.startTime = startTime;
    }

    /**
     * Method to print the details of the talk
     */
    @Override
    public String toString() {
        return "Talk{" +//
                "id='" + id + '\'' +
                ", speaker='" + speaker + '\'' +
                ", title='" + title + '\'' +
                ", startTime='" + startTime + '\'' +
                '}' ;

    }

    /**
     * Method to check if two Talk objects are equal
     *
     * @param o The Talk object to be compared with
     * @return true if the two Talk objects are equal, false otherwise
     */
    @Override
    public int compareTo(Talk o) {
        return -this.startTime.compareTo(o.startTime);
    }
}
