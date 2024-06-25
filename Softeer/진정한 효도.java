import java.io.*;
import java.util.*;

public class Main {
    static int minPrice = Integer.MAX_VALUE;
    static int[][] map = new int[3][3];
    static int sumPrice = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i=0; i<3 ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            sumPrice = 0;
            for (int j = 0 ; j < 3 ; j++){
                int price = Integer.parseInt(st.nextToken());
                map[i][j] = price;
                sumPrice += price;
            }
        }
        for (int i=0; i<3 ; i++){
            int[] rTmp= {map[i][0],map[i][1],map[i][2]};
            int[] cTmp= {map[0][i],map[1][i],map[2][i]};
            Arrays.sort(rTmp);
            Arrays.sort(cTmp);
            
            int rMidPrice = rTmp[1];
            int cMidPrice = cTmp[1];
            int rPrice = Math.abs(map[i][2]-rMidPrice) + Math.abs(map[i][1]-rMidPrice) + Math.abs(map[i][0]-rMidPrice);
            int cPrice = Math.abs(map[2][i]-cMidPrice) + Math.abs(map[1][i]-cMidPrice) + Math.abs(map[0][i]-cMidPrice);
            
            minPrice = Math.min(Math.min(minPrice, cPrice),rPrice);
        }
        System.out.println(minPrice);
    }
}
