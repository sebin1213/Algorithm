import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = new int[]{0,1,0,-1};
    static int[] dy = new int[]{1,0,-1,0};
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];

        int[][] rDp = new int[n][n];
        int[][] dp = new int[n][n];
        
        StringTokenizer st;
        for (int i = 0; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n ; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for (int i = 0; i < n ; i++){
            for (int j = 0; j < n ; j++){
                int up = (i-1) < 0 ? 0:dp[i-1][j];
                int left = (j-1) < 0 ? 0:dp[i][j-1];
                dp[i][j] =Math.max(left + arr[i][j], up + arr[i][j]);
            }
        }
        for (int i = n-1; i >= 0 ; i--){
            for (int j = n-1; j >= 0 ; j--){
                int down = (i+1) >= n ? 0:rDp[i+1][j];
                int right = (j+1) >= n ? 0:rDp[i][j+1];
                rDp[i][j] = Math.max(down + arr[i][j], right + arr[i][j]);
            }
        }
        
        int maxValue = 0;
        for (int i = 0; i < n ; i++){
            for (int j = 0; j < n ; j++){
                maxValue = Math.max(maxValue, rDp[i][j]+dp[i][j]);
            }
        }
        System.out.println(maxValue);
        
    }
}
