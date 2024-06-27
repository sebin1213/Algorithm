import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            if (m == 0 && n == 0) break;
            List<int[]> edges = new ArrayList<>();
            int totalCost = 0;

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int z = Integer.parseInt(st.nextToken());
                edges.add(new int[]{z, x, y});
                totalCost += z;
            }

            Collections.sort(edges, Comparator.comparingInt(a -> a[0]));

            parent = new int[m];
            for (int i = 0; i < m; i++) {
                parent[i] = i;
            }

            int mstCost = 0;
            for (int[] edge : edges) {
                int cost = edge[0];
                int u = edge[1];
                int v = edge[2];
                int parentU = find(u);
                int parentV = find(v);
                if (find(u) != find(v)) {
                    parent[parentU] = Math.min(parentU,parentV);
                    parent[parentV] = Math.min(parentU,parentV);

                    mstCost += cost;
                }
            }

            sb.append(totalCost - mstCost).append("\n");
        }

        System.out.print(sb.toString());
    }

    static int find(int u) {
        if (parent[u] != u) {
            parent[u] = find(parent[u]);
        }
        return parent[u];
    }
}
