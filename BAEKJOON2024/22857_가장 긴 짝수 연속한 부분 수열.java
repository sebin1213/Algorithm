import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int s = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        int[][] check = new int[s+1][2]; // 1 - 짝수 개수, 0 - 홀수 개수
        for (int i = 1 ; i < s+1 ; i++){
            int num = Integer.parseInt(st.nextToken());
            if (num % 2 == 0){
                check[i][1] = check[i-1][1] + 1;
                check[i][0] = check[i-1][0];
            }else{
                check[i][0] = check[i-1][0] + 1;
                check[i][1] = check[i-1][1];
            }
        }
        int maxNum = 0;
        int i = s;
        int j = s-1;
        while (j >= 0){
            if ((check[i][0]-check[j][0]) > n){
                i--;
            }
            maxNum = Math.max(maxNum, check[i][1] - check[j][1]);
            j--;
        }
        System.out.println(maxNum);
    }
}
