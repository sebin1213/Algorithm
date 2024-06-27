import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = new int[]{0,0,1,-1};
    static int[] dy = new int[]{1,-1,0,0};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<int[]> gList = new ArrayList<>();
        char[][] arr = new char[n][m];
        int[][] visited = new int[n][m];
        int[] exit = new int[2];
        int[] loc = new int[2];

        for (int i = 0 ; i < n ; i++){
            String row = br.readLine();
            for (int j = 0 ; j < m ; j++){
                arr[i][j] = row.charAt(j);
                if (arr[i][j] == 'G'){
                    gList.add(new int[]{i,j});
                }
                if (arr[i][j] == 'D'){
                    exit[0] = i;
                    exit[1] = j;
                }
                if (arr[i][j] == 'N'){
                    loc[0] = i;
                    loc[1] = j;            
                }
            }
        }
        int gTime = Integer.MAX_VALUE;
        for(int[] g : gList){
            gTime = Math.min(gTime, (Math.abs(exit[0] - g[0]) + Math.abs(exit[1] - g[1])));
        }
        if ((Math.abs(exit[0] - loc[0]  + Math.abs(exit[1] - loc[1]))) >= gTime){
            System.out.println("No");
            return;
        }
        
        Deque<int[]> queue = new ArrayDeque<>();
        queue.addLast(new int[]{loc[0], loc[1], 1});
        visited[loc[0]][loc[1]] = 1;

        while (queue.size() > 0){
            int[] nowLoc = queue.removeFirst();
            int x = nowLoc[0];
            int y = nowLoc[1];
            int z = nowLoc[2];
            
            for (int i =0 ; i < 4 ; i++){
                int nx = dx[i] + x;
                int ny = dy[i] + y;
                if (nx>= 0 && nx < n && ny >= 0 && ny < m){
                    if (arr[nx][ny] != '#' && visited[nx][ny] == 0){
                        queue.addLast(new int[]{nx, ny, z+1});
                        visited[nx][ny] = z+1;
                    }
                }
            }
        }
        // 출발시간을 1로 설정하여 1 제거
        if (0 < (visited[exit[0]][exit[1]] - 1) && (visited[exit[0]][exit[1]] - 1) < gTime){
            System.out.println("Yes");
        } else{
            System.out.println("No");
            
        }

    }
}
