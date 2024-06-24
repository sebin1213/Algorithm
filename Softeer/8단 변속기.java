import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        boolean state = false;
        int n = Integer.parseInt(st.nextToken());
        if ( 1 == n){
            for (int i = 2 ; i <= 8 ; i++){
                n = Integer.parseInt(st.nextToken());
                if (n != i){
                    System.out.println("mixed");
                    return;
                }
            }
            System.out.println("ascending");
            return;
        } else if ( 8 == n){
            for (int i = 7 ; i >= 1 ; i--){
                n = Integer.parseInt(st.nextToken());
                if (n != i){
                    System.out.println("mixed");
                    return;
                }
            }
            System.out.println("descending");
            return;
        }
        System.out.println("mixed");
    }
}
