import java.util.Arrays;
import java.util.Collections;

public class Test implements Comparable<Test> {

    public String id, speaker, title, startTime;

    public static Test[][] talkList;
    public int capacity = 4;



    public Test(String id, String speaker, String title, String startTime) {
        this.id = id;
        this.speaker = speaker;
        this.title = title;
        this.startTime = startTime;
    }
    public static void print(Test[] arr){
        for (int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
    }
    public static void sort(Test[] arr){
        Arrays.sort(arr);
    }
    public static void main(String[] args) {
        Test talk1 = new Test("1", "Speaker 1", "Talk A", "2023-11-07T09:04:00");
        Test talk2 = new Test("2", "Speaker 2", "Talk B", "2023-11-07T10:02:00");
        Test talk3 = new Test("3", "Speaker 3", "Talk C", "2023-11-07T14:08:00");
        Test talk4 = new Test("4", "Speaker 4", "Talk D", "2023-11-07T15:06:00");

        Test []arr = new Test[4];

        arr[0] = talk1;
        arr[1] = talk2;
        arr[2] = talk3;
        arr[3] = talk4;

        sort(arr);

        print(arr);

    }

    @Override
    public String toString() {
        return "\nTalk{" +
                "id='" + id + '\'' +
                ", speaker='" + speaker + '\'' +
                ", title='" + title + '\'' +
                ", startTime='" + startTime + '\'' +
                '}' ;
    }

    @Override
    public int compareTo(Test a) {
        return this.startTime.compareTo(a.startTime);
    }
}