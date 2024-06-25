import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());        

        List<int[]> ruleList = new ArrayList<>();
        
        for (int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            int move = Integer.parseInt(st.nextToken());
            int speed = Integer.parseInt(st.nextToken());
            ruleList.add(new int[]{move,speed});
        }
        
        int searchIdx = 0;
        int maxOverSpeed = 0;
        for (int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int move = Integer.parseInt(st.nextToken());
            int speed = Integer.parseInt(st.nextToken());
            while (searchIdx < ruleList.size()){
                if (move == 0){
                    break;
                }
                if (ruleList.get(searchIdx)[0] > move){
                    ruleList.get(searchIdx)[0] -= move;
                    maxOverSpeed = Math.max(maxOverSpeed, (speed - ruleList.get(searchIdx)[1]));
                    break;
                }else{
                    move -= ruleList.get(searchIdx)[0];
                    maxOverSpeed = Math.max(maxOverSpeed, (speed - ruleList.get(searchIdx)[1]));
                    searchIdx++;
                }
            }
        }
        maxOverSpeed = (maxOverSpeed < 0) ? 0 : maxOverSpeed;
        System.out.println(maxOverSpeed);
    }
}
