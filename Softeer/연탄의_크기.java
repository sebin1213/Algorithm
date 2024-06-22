import java.io.*;
import java.util.*;

public class Main {
    static int[] SOSU = {2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97};
    static int[] count = new int[SOSU.length];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int result = 0;
        for (int i=0 ; i < n ; i++){
            int radius  = Integer.parseInt(st.nextToken());

            for (int s_idx = 0 ; s_idx < SOSU.length ; s_idx++){
                if(SOSU[s_idx] > radius){
                    break;
                }
                if (radius % SOSU[s_idx] == 0){
                    count[s_idx] +=1;
                }
            }
        }
        System.out.println(Arrays.stream(count).max().getAsInt());
    }
}
