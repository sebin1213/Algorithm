import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = new int[]{1,-1,0,0};
    static int[] dy = new int[]{0,0,1,-1};
    static int maxSum = 0;
    static int[][] arr;
    static int[][] fArr;
    static int n;
    static int m;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int sum = 0;
        
        arr = new int[n][n];
        for(int i =0; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j =0; j < n ; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        fArr = new int[m][2];
        for(int i = 0; i < m ; i++){
            st = new StringTokenizer(br.readLine());
            fArr[i][0] = Integer.parseInt(st.nextToken())-1;
            fArr[i][1] = Integer.parseInt(st.nextToken())-1;

            sum += arr[fArr[i][0]][fArr[i][1]];
            arr[fArr[i][0]][fArr[i][1]] = 0;
        }
        
        int r = fArr[0][0];
        int c = fArr[0][1];
        dfs(0,r,c,sum,0);
        System.out.println(maxSum);
    }
    public static void dfs(int idx,int x,int y, int total, int depth){
        if (depth == 3){
            if(idx+1 < m){
                int r = fArr[idx+1][0];
                int c = fArr[idx+1][1];
                dfs(idx+1, r, c, total, 0);
            }else{
                maxSum = Math.max(total,maxSum);
            }
            return;
        }
        
        for (int i =0; i < 4 ; i++){
            int nx = dx[i]+x;
            int ny = dy[i]+y;
            if (nx >= 0 && nx < n && ny >= 0 && ny < n){
                int arrValue = arr[nx][ny];
                arr[nx][ny] = 0;
                dfs(idx,nx,ny, total+arrValue, depth+1);
                arr[nx][ny] = arrValue;
            }
        }
    }
}
