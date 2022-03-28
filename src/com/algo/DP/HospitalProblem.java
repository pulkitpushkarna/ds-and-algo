package com.algo.DP;

import java.util.*;

public class HospitalProblem {
    public static void main(String[] args) {
        int[][] arr = {{1, 1, 5, 2, 3},
                {4, 5, 6, 4, 3},
                {9, 4, 4, 1, 5}};
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
                int id = arr[i][j];
                if (Objects.isNull(map.get(id))) {
                    Set<Integer> set = new HashSet<>();
                    set.add(i);
                    map.put(id, set);
                } else {
                    map.get(id).add(i);
                }
            }
            System.out.println();
        }
        System.out.println(map);
        long count = map.values().stream().filter(list -> list.size() >= 2).count();
        System.out.println("Answer::" + count);
    }
}
