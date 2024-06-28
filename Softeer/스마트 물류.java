import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        String line = br.readLine();
        boolean[] visited = new boolean[n];
        int count = 0;
        for(int i =0; i< n ; i++){
            if(line.charAt(i)=='P'){
                int stIdx = (i-k) < 0 ? 0: (i-k);
                boolean leftCheck = false;
                for(int j = stIdx ; j < i ; j++){
                    if(line.charAt(j)=='H' && visited[j] ==false){
                        visited[j] = true;
                        count++;
                        leftCheck = true;
                        break;
                    }
                }
                if (!leftCheck){
                    int edIdx = (i+k) >= n ? n-1: (i+k);
                    for(int j = i+1 ; j <= edIdx ; j++){
                        if(line.charAt(j)=='H' && visited[j] ==false){
                            visited[j] = true;
                            count++;
                            break;
                        }
                    }
                }               
            }
        }
        System.out.println(count);
    }
}
