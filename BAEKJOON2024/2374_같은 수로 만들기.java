import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int lastNum = Integer.parseInt(br.readLine());
        long result = 0;
        if (num > 1){
            int nowNum = Integer.parseInt(br.readLine());
            boolean asc = lastNum < nowNum;
            int minNum = Math.min(lastNum,nowNum);
            int maxNum = Math.max(lastNum,nowNum);

            for (int i=2 ; i < num ; i++){
                lastNum = nowNum;
                nowNum = Integer.parseInt(br.readLine());
                if (lastNum > nowNum){
                    if (asc) {
                        result += (Math.min(lastNum, maxNum) - minNum);
                        asc = false;
                        minNum = lastNum;
                    }
                    minNum = Math.min(nowNum,lastNum);
                }
                else if (lastNum < nowNum){
                    asc = true;
                    maxNum = Math.max(maxNum, nowNum);
                }
            }
            result += (maxNum - minNum);
        }
        System.out.println(result);
    }
}
