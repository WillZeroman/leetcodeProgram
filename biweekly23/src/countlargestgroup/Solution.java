package countlargestgroup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public int countLargestGroup(int n) {
        Map<Integer, Integer> result = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            int bit = countBit(i);
            if (result.containsKey(bit)) {
                result.put(bit, result.get(bit) + 1);
            } else {
                result.put(bit, 1);
            }
        }
        List<Integer> list = new ArrayList<>(result.values());
        Collections.sort(list);
        int res = 0;
        int value = list.get(list.size() - 1);
        for (int i = list.size() - 1; i >= 0; i--) {
            if (value == list.get(i)) {
                res++;
            } else {
                break;
            }
        }
        return res;
    }

    private int countBit(int num) {
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countLargestGroup(13));
        System.out.println(new Solution().countLargestGroup(2));
        System.out.println(new Solution().countLargestGroup(15));
        System.out.println(new Solution().countLargestGroup(24));
    }
}
