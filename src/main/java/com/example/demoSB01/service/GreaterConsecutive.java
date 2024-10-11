package com.example.demoSB01.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GreaterConsecutive {

    public static int consecutive(int[] arr) {
        //int arr[] = { 4, 3, 8, 1, 2, 6, 100, 9 };
        List<Integer> sortedList = Arrays.stream(arr).sorted().boxed().collect(Collectors.toList());
        int count=1;
        List<Integer> counts = new ArrayList<Integer>();
        for (int i=0;i<sortedList.size()-1;i++) {
            if (sortedList.get(i+1)-sortedList.get(i)==1) {
                count++;
            }
            else {
                counts.add(count);
                count=1;
            }
        }
        counts.add(count);
        return counts.stream().max(Integer::compareTo).get();
    }

}
