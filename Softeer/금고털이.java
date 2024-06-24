import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int w = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        List<int[]> list = new ArrayList<>();
        for (int i=0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int m = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            list.add(new int[]{p, m});
        }
        Collections.sort(list, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                if(a[0] != b[0]){
                    return Integer.compare(a[0],b[0]) * -1;
                }else{
                    return Integer.compare(a[1],b[1]) * -1;
                }
            }
        });
        int idx = 0;
        int result = 0;
        while (true){
            int m = list.get(idx)[1];
            int p = list.get(idx)[0];
            if ( w > m){
                w -= m;
                result += (m * p);
            }else{
                result += (w * p);
                break;
            }
            idx++;
        }
        System.out.println(result);
    }
}
