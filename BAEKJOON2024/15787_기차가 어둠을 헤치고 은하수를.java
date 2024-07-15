import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 기차의 수
        int M = Integer.parseInt(st.nextToken()); // 명령의 수

        boolean[][] trains = new boolean[N + 1][20]; // 기차의 상태를 저장할 배열

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int trainIndex = Integer.parseInt(st.nextToken());
            if (command == 1) {
                int seatIndex = Integer.parseInt(st.nextToken());
                trains[trainIndex][seatIndex - 1] = true;
            } else if (command == 2) {
                int seatIndex = Integer.parseInt(st.nextToken());
                trains[trainIndex][seatIndex - 1] = false;
            } else if (command == 3) {
                for (int j = 19; j > 0; j--) {
                    trains[trainIndex][j] = trains[trainIndex][j - 1];
                }
                trains[trainIndex][0] = false;
            } else if (command == 4) {
                for (int j = 0; j < 19; j++) {
                    trains[trainIndex][j] = trains[trainIndex][j + 1];
                }
                trains[trainIndex][19] = false;
            }
        }

        Set<String> uniqueStates = new HashSet<>();
        for (int i = 1; i <= N; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 20; j++) {
                sb.append(trains[i][j] ? '1' : '0');
            }
            uniqueStates.add(sb.toString());
        }

        System.out.println(uniqueStates.size());
    }
}