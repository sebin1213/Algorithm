import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Long[][] meetings = new Long[N][2];

        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            meetings[i][0] = Long.parseLong(st.nextToken());
            meetings[i][1] = Long.parseLong(st.nextToken());
        }

        System.out.println(minMeetingRooms(meetings));
    }

    public static int minMeetingRooms(Long[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, Comparator.comparingLong(a -> a[0]));
        PriorityQueue<Long> minHeap = new PriorityQueue<>();

        for (Long[] interval : intervals) {
            if (!minHeap.isEmpty() && interval[0] >= minHeap.peek()) {
                minHeap.poll();
            }
            minHeap.add(interval[1]);
        }

        return minHeap.size();
    }
}
