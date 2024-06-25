import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = new int[]{0,0,1,-1};
    static int[] dy = new int[]{1,-1,0,0};
    static int blockSize;

    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        List<Integer> resultList = new ArrayList<>();
        int[][] arr = new int[n][n];
        for (int i = 0 ; i < n ; i++){
            String row = br.readLine();
            for (int j = 0 ; j < n ; j++){
                arr[i][j] = row.charAt(j) - '0';
            }
        }
        for (int i = 0 ; i < n ; i++){
            for (int j = 0 ; j < n ; j++){
                if(arr[i][j] == 1){
                    blockSize = 1;
                    arr[i][j] = 0;
                    dfs(arr,i,j,n);
                    resultList.add(blockSize);
                }
            }
        }
        Collections.sort(resultList);
        StringBuilder sb = new StringBuilder();
        sb.append(resultList.size()+"\n");
        for (int result : resultList){
            sb.append(result+"\n");
        }
        System.out.println(sb.toString());
    }

    public static void dfs(int[][] arr, int x, int y, int n){
        for (int i = 0 ; i < 4 ; i++){
            int nx = dx[i] + x;
            int ny = dy[i] + y;
            if (0 <= nx && nx < n && 0 <= ny && ny < n && arr[nx][ny]==1){
                arr[nx][ny] = 0;
                blockSize++;
                dfs(arr,nx,ny,n);
            }
        }
    }
}
