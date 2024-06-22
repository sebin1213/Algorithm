import java.io.*;
import java.util.*;

public class Main {
    static boolean[] nodes;
    static int node = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken()); // 2 ≤ N < 2^20
        int q = Integer.parseInt(st.nextToken());
        nodes = new boolean[n+1];
        for (int i =0; i < q ; i++){
            int duck = Integer.parseInt(br.readLine());
            node = 0;
            check(duck);
            if (node==0){
                nodes[duck]=true;
            }
            sb.append(node+"\n");
        }
        System.out.println(sb);
    }

    public static void check(int idx){
        while (idx > 1){
            if (nodes[idx]) {
                node = idx;
            }
            idx /= 2;
        }
    }
}
