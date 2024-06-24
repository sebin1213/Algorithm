import java.io.*;
import java.util.*;

public class Main {
    static int[][] arr = new int[100][100];
    static int rowLen =3;
    static int colLen = 3;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken()) -1;
        int c = Integer.parseInt(st.nextToken()) -1;
        int k = Integer.parseInt(st.nextToken());

        for (int i =0; i < 3;i++){
            st = new StringTokenizer(br.readLine());
            for (int j =0; j < 3;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int count = 0;
        while (count <= 100){
            if (arr[r][c] == k) {
                System.out.println(count);
                return;
            }
            if (rowLen >= colLen) {
                rowSort();
            } else {
                colSort();
            }
            count++;
        }
        System.out.println(-1);

    }

    public static void rowSort(){
        int maxColLen = 0;
        for (int i=0; i < rowLen ; i++){
            Map<Integer,Integer> map = new HashMap<>();
            for (int j = 0; j < colLen ; j++){
                if (arr[i][j] != 0){
                    map.put(arr[i][j], map.getOrDefault(arr[i][j], 0) + 1);
                }
            }
            List<int[]> mapSortList = new ArrayList<>();
            for (Map.Entry<Integer,Integer> entry : map.entrySet()){
                mapSortList.add(new int[]{entry.getKey(), entry.getValue()});
            }
            Collections.sort(mapSortList, new Comparator<int[]>(){
                @Override
                public int compare(int[] a, int[] b){
                    if (a[1] != b[1]){
                        return Integer.compare(a[1],b[1]);
                    }
                    else{
                        return Integer.compare(a[0],b[0]);
                    }
                }
            });
            int idx = 0;
            for (int[] pair : mapSortList) {
                arr[i][idx++] = pair[0];
                arr[i][idx++] = pair[1];
            }
            for (int j = idx ; j < 100 ; j++ ){
                arr[i][j] = 0;
            }
            maxColLen = Math.max(maxColLen, idx);
        }
        colLen = maxColLen;
    }

    public static void colSort(){
        int maxRowLen = 0;
        for (int i=0; i < colLen ; i++){
            Map<Integer,Integer> map = new HashMap<>();
            for (int j = 0; j< rowLen ; j++){
                if (arr[j][i] != 0){
                    map.put(arr[j][i], map.getOrDefault(arr[j][i], 0) + 1);
                }
            }
            List<int[]> mapSortList = new ArrayList<>();
            for (Map.Entry<Integer,Integer> entry : map.entrySet()){
                mapSortList.add(new int[]{entry.getKey(), entry.getValue()});
            }
            Collections.sort(mapSortList, new Comparator<int[]>(){
                public int compare(int[] a, int[] b){
                    if (a[1] != b[1]){
                        return Integer.compare(a[1],b[1]);
                    }
                    else{
                        return Integer.compare(a[0],b[0]);
                    }
                }
            });
            int idx = 0;
            for (int[] pair : mapSortList) {
                arr[idx++][i] = pair[0];
                arr[idx++][i] = pair[1];
            }

            for (int j = idx ; j < colLen ; j++ ){
                arr[j][i] = 0;
            }
            maxRowLen = Math.max(maxRowLen, idx);
        }
        rowLen = maxRowLen;
    }
}