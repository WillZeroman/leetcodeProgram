package uniqueint;

import java.util.*;

public class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        int len = arr.length;
        if (k == len) {
            return 0;
        }
        Map<Integer, NumCount> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int key = arr[i];
            if (map.containsKey(key)) {
                NumCount count = map.get(key);
                count.num++;
                map.put(key, count);
            } else {
                NumCount count = new NumCount();
                count.num = 1;
                map.put(key, count);
            }
        }
        System.out.println(map);
        List<NumCount> list = new ArrayList<>(map.values());
        list.sort(new Comparator<NumCount>() {
            @Override
            public int compare(NumCount o1, NumCount o2) {
                return o1.num - o2.num;
            }
        });
        System.out.println(list);
        int size = list.size();
        int i = 0;
        for (; i < size; i++) {
            NumCount count = list.get(i);
            k -= count.num;
            if (k < 0) {
                break;
            }
        }
        return size - i;
    }

    class NumCount {
        int val;
        int num;

        @Override
        public String toString() {
            return "NumCount{" +
                    "val=" + val +
                    ", num=" + num +
                    '}';
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 5, 4};
        System.out.println(new Solution().findLeastNumOfUniqueInts(arr, 1));
        int[] arr1 = {5};
        System.out.println(new Solution().findLeastNumOfUniqueInts(arr1, 1));
        int[] arr2 = {4,3,1,1,3,3,2};
        System.out.println(new Solution().findLeastNumOfUniqueInts(arr2, 4));
    }
}
