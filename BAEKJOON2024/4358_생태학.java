import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String treeNm;
        int totalNum = 0;
        Map<String, Integer> treeMap = new HashMap<>();
        while ((treeNm = br.readLine()) != null && !treeNm.isEmpty()){
            int count = treeMap.getOrDefault(treeNm,0);
            treeMap.put(treeNm, count+1);
            totalNum ++;
        }
        Object[] keys =  treeMap.keySet().toArray();
        Arrays.sort(keys);
        List<String> treeList = new ArrayList<>();
        for(String key :treeMap.keySet()){
            treeList.add(key);
        }
        Collections.sort(treeList);

        for (Object key:keys){
            int count = treeMap.get((String) key);
            double per = (double) count / totalNum * 100;
            System.out.println(key + " " + String.format("%.4f",per));
        }
    }
}