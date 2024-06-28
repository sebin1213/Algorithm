import java.io.*;
import java.util.*;

public class Main {
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = new int[]{0,0,-1,1};
    static int[] dy = new int[]{-1,1,0,0};
    static int n;
    static int maxVal=0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        visited = new boolean[n][n];
        StringTokenizer st;
        for (int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0;j<n;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0,0);
        System.out.println(maxVal);
    }

    static void dfs(int depth, int sum){
        if (depth ==4){
            return;
        }
        for (int x=0;x<n;x++){
            for (int y=0;y<n;y++){
                if (visited[x][y] == false){
                    visited[x][y] = true;
                    for (int i=0 ; i < 4 ; i++){
                        int nx= dx[i]+x;
                        int ny= dy[i]+y;
                        if(nx>=0 && nx < n && ny>=0 && ny < n && visited[nx][ny] == false){
                            visited[nx][ny] = true;
                            maxVal = Math.max(maxVal,sum+arr[x][y]+arr[nx][ny]);
                            dfs(depth+1, sum+arr[x][y]+arr[nx][ny]);
                            visited[nx][ny] = false;
                        }
                    }
                    visited[x][y] = false;
                }
            }
        }

        // if (visited[x][y] == false){
        //     for (int i=0 ; i < 4 ; i++){
        //         nx= dx[i]+x;
        //         ny= dy[i]+y;
        //         if(nx>=0 && nx < n && ny>=0 && ny < n && visited[nx][ny] == false){
        //             dfs(nx,ny,depth+1, sum+arr[x][y]+arr[nx][ny]);
        //         }
        //     }
        // }
    }
}
