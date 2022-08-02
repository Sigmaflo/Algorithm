import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Meeting implements Comparable<Meeting>{
        int start;
        int end;

        public Meeting(int strat, int end){
            this.start = strat;
            this.end = end;
        }

        @Override
        public int compareTo(Meeting o) {
            if(this.end != o.end){
                return this.end - o.end;
            }else{
                return this.start - o.start;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Meeting> meetingList = new LinkedList<>();
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startTime = Integer.parseInt(st.nextToken());
            int endTime = Integer.parseInt(st.nextToken());
            meetingList.add(new Meeting(startTime, endTime));
        }
        Collections.sort(meetingList);
        int count = 0;
        Meeting prev = new Meeting(0 ,0);
        for(Meeting meeting : meetingList){
            if(prev.end <= meeting.start){
                prev = meeting;
                count++;
            }
        }
        System.out.println(count);
    }
}
