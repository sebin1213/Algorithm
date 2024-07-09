import java.io.*;
import java.util.*;

public class Main {
    static int[][] arr = new int[100][100];
    static int rowLen = 3;
    static int colLen = 3;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken()) - 1;
        int c = Integer.parseInt(st.nextToken()) - 1;
        int k = Integer.parseInt(st.nextToken());

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;
        while (count <= 100) {
            if (arr[r][c] == k) {
                System.out.println(count);
                return;
            }
            if (rowLen >= colLen) {
                sortArray(true);
            } else {
                sortArray(false);
            }
            count++;
        }
        System.out.println(-1);
    }

    public static void sortArray(boolean isRow) {
        int maxLen = 0;
        int outerLen = isRow ? rowLen : colLen;
        int innerLen = isRow ? colLen : rowLen;

        for (int i = 0; i < outerLen; i++) {
            int[] tempArray = new int[innerLen];
            for (int j = 0; j < innerLen; j++) {
                tempArray[j] = isRow ? arr[i][j] : arr[j][i];
            }

            List<int[]> sortedList = getSortedList(tempArray, innerLen);

            int idx = 0;
            for (int[] pair : sortedList) {
                if (isRow) {
                    arr[i][idx++] = pair[0];
                    arr[i][idx++] = pair[1];
                } else {
                    arr[idx++][i] = pair[0];
                    arr[idx++][i] = pair[1];
                }
            }

            if (isRow) {
                Arrays.fill(arr[i], idx, 100, 0);
            } else {
                for (int j = idx; j < 100; j++) {
                    arr[j][i] = 0;
                }
            }

            maxLen = Math.max(maxLen, idx);
        }

        if (isRow) {
            colLen = maxLen;
        } else {
            rowLen = maxLen;
        }
    }

    public static List<int[]> getSortedList(int[] array, int length) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            if (array[i] != 0) {
                map.put(array[i], map.getOrDefault(array[i], 0) + 1);
            }
        }

        List<int[]> sortedList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            sortedList.add(new int[]{entry.getKey(), entry.getValue()});
        }

        sortedList.sort((a, b) -> a[1] != b[1] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));
        return sortedList;
    }
}