import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer stList = new StringTokenizer(br.readLine(), " ");
        int q_n = Integer.parseInt(br.readLine());

        int[] check = new int[n+1];
        int last = Integer.parseInt(stList.nextToken());
        for (int i = 1; i < n ; i++){
            int prev = Integer.parseInt(stList.nextToken());
            check[i] = last > prev ? check[i-1]+1 : check[i-1];
            last = prev;
        }
        check[n]=check[n-1];

        StringTokenizer question;
        for (int i = 0 ; i < q_n ; i++){
            question = new StringTokenizer(br.readLine(), " ");
            int q_start= Integer.parseInt(question.nextToken());
            int q_end= Integer.parseInt(question.nextToken());
            System.out.println(check[q_end-1]-check[q_start-1]);
        }
    }
}
