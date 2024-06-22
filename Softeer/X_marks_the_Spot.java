import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());        
        List<String> list = new ArrayList<>();
        StringTokenizer st;
        StringBuilder result = new StringBuilder();
        for (int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            String firstWord = st.nextToken();
            String secondeWord = st.nextToken();
            for (int j = 0 ; j < firstWord.length() ; j++){
                char w = firstWord.charAt(j);
                if (w == 'x' || w == 'X'){
                    result.append(secondeWord.charAt(j));
                    break;
                }
            }
        }
        System.out.println(result.toString().toUpperCase());
    }
}
