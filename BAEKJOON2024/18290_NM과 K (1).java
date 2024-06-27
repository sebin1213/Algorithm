import java.io.*;
import java.util.*;

public class Main {
    static int[][] arr;
    static boolean[][] visited;
    static int maxTotal = Integer.MIN_VALUE;
    static int n;
    static int m;
    static int k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n+2][m+2];
        visited = new boolean[n+2][m+2];
        for (int i = 1; i < n+1 ; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < m+1 ; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(1,1,0,0);
        System.out.println(maxTotal);
    }
    static void dfs(int x, int y, int depth, int total){
        if (depth == k){
            maxTotal = Math.max(maxTotal, total);
            return;
        }

        for (int i = 1 ; i < n+1 ; i++){
            for (int j = 1 ; j < m+1 ; j++){
                if (arr[i][j] != Integer.MIN_VALUE){
                    int right = arr[i+1][j];
                    int left = arr[i-1][j];
                    int down = arr[i][j+1];
                    int up = arr[i][j-1];
                    int val = arr[i][j];

                    arr[i+1][j] = Integer.MIN_VALUE;
                    arr[i-1][j] = Integer.MIN_VALUE;
                    arr[i][j+1] = Integer.MIN_VALUE;
                    arr[i][j-1] = Integer.MIN_VALUE;
                    arr[i][j] = Integer.MIN_VALUE;
                    dfs(i, j, depth + 1, total+val);

                    arr[i+1][j] = right;
                    arr[i-1][j] = left;
                    arr[i][j+1] = down;
                    arr[i][j-1] = up;
                    arr[i][j] = val;
                }
            }
        }
    }
}
