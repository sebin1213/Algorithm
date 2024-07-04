import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[] weights = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            weights[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(weights);

        if (event(N, C, weights)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    private static boolean event(int n, int c, int[] weights) {
        if (binarySearch(0, n - 1, c, weights) >= 0) { // Check for single item
            return true;
        }
        for (int i = 0; i < n; i++) { // Check for pairs of items
            int diff = c - weights[i];
            if (diff > 0 && binarySearch(i + 1, n - 1, diff, weights) >= 0) {
                return true;
            }
        }
        for (int i = 0; i < n; i++) { // Check for triples of items
            for (int j = i + 1; j < n; j++) {
                int diff = c - (weights[i] + weights[j]);
                if (diff > 0 && binarySearch(j + 1, n - 1, diff, weights) >= 0) {
                    return true;
                }
            }
        }
        return false;
    }

    private static int binarySearch(int start, int end, int c, int[] weights) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if (weights[mid] == c) {
                return mid;
            }
            if (weights[mid] < c) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
