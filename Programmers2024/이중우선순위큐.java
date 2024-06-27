import java.io.*;
import java.util.*;


class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {};
        TreeMap<Integer,Integer> map = new TreeMap<>();
        StringTokenizer st;
        for (String operation : operations){
            st = new StringTokenizer(operation, " ");
            String o = st.nextToken();
            int n = Integer.parseInt(st.nextToken());
            if (o.equals("I")){
                map.put(n, map.getOrDefault(n,0)+1);
            }
            if (o.equals("D") && map.size() > 0){
                if (n == -1){
                    int key = map.firstKey();
                    if (map.get(key) == 1){
                        map.remove(key);
                    }else{
                        map.put(key, map.get(key)-1);
                    }
                }else{
                    int key = map.lastKey();
                    if (map.get(key) == 1){
                        map.remove(key);
                    }else{
                        map.put(key, map.get(key)-1);
                    }
                }
            }
        }
        if (map.size() == 0){
            return new int[]{0,0};
        }else{
            int firstKey = map.firstKey();
            int lastKey = map.lastKey();
            return new int[]{lastKey, firstKey};
        }
    }
}
