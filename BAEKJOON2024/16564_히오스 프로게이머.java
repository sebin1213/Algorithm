import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> queue = new PriorityQueue();

        for (int i = 0; i < n ; i++){
            int t = Integer.parseInt(br.readLine());
            int count = map.getOrDefault(t, 0);
            map.put(t, count+1);
            if (count == 0){
                queue.add(t);
            }
        }
        int prev = queue.remove();
        while (queue.size() > 0){
            int next = queue.remove();
            int levelUp = (next-prev) * map.get(prev);
            if (levelUp > k){
                break;
            }
            k -= levelUp;
            map.put(next, map.get(next) + map.get(prev));
            prev = next;
        }
        int l = 0;
        if (k != 0){
            l = k / map.get(prev);
        }
        System.out.println(prev+l);
    }
}
