import java.io.*;
import java.util.*;

public class Main {
    static Long maxLong = Long.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Long k = Long.parseLong(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        for(int i =0 ; i< n ; i++){
            k = (k * p) % 1000000007;            
        }
        System.out.println(k);
    }
}
