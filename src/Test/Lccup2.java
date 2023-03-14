package Test;

import java.util.*;

public class Lccup2 {

    public int transportationHub(int[][] path) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = path.length;

        for (int i = 0; i < 2 * n; i = i + 2) {
            map.put(path[i / 2][i % 2], path[i / 2][i % 2 + 1]);
        }

        Integer[] key = new Integer[1000];
        Integer[] value = new Integer[1000];
        int k = 0, kk = 0;

        for (int i = 0; i < 1000; i++) {
            if (map.containsKey(i)) {
                key[k++] = i;
            }
        }
        for (int i = 0; i < 1000; i++) {
            if (map.containsValue(i)) {
                value[kk] = i;
            }
        }


        for (Integer x : value) {
            if (map.containsValue(x) && (!map.containsKey(x))) {
                for (Integer y : key) {
                    while (y != x) {
                        if (map.containsKey(y)) {
                            return x;
                        }
                    }
                }
            }

//        for (int i = 0; i < 1000; i++) {
//            if(map.containsValue(i) && (!map.containsKey(i))){
//                for (int j = 0; j < 1000; j++) {
//                    while (j!=i){
//                        if(map.containsKey(j)){
//                            return i;
//                        }
//                    }
//                }
//            }
//
//        }


        }
        return -1;
    }
}

