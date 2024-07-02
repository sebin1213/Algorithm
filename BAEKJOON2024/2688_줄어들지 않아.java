import java.util.*;
import java.io.*;

public class Main {
    static Long[][] li = new Long[65][10];
    static {
        for (int j = 0; j < 10; j++) {
            li[0][j] = j + 1l;
        }
        for (int j = 0; j < 65; j++) {
            li[j][0] = 1l;
        }
        for (int i = 1; i < 65; i++) {
            for (int j = 1; j < 10; j++) {
                li[i][j] = li[i][j - 1] + li[i - 1][j];
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            sb.append(li[num - 1][9]+"\n");
        }
        System.out.println(sb);
    }
}
