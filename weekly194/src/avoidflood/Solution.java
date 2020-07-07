package avoidflood;

import java.util.*;

public class Solution {
    public int[] avoidFlood(int[] rains) {
        int[] res = new int[rains.length];
        HashSet<Integer> hasRain = new HashSet<>(rains.length);
        int lastRain = -1;
        int lastNotRain = -1;
        for (int i = 0; i < rains.length; i++) {
            if (rains[i] > 0) {
                lastRain = rains[i];
                if (hasRain.contains(lastRain)) {
                    return new int[0];
                } else {
                    res[i] = -1;
                    hasRain.add(lastRain);
                }
            } else {
                int j = Math.max(i + 1, lastNotRain);
                boolean hasFound = false;
                for (; j < rains.length && !hasFound; j++) {
                    if (rains[j] > 0 && hasRain.contains(rains[j])) {
                        res[i] = rains[j];
                        hasRain.remove(rains[j]);
                        hasFound = true;
                    } else {
                        lastNotRain = j;
                    }
                }
                if (!hasFound) {
                    if (!hasRain.isEmpty()) {
                        List<Integer> list = new ArrayList<>(hasRain);
                        hasRain.remove(list.get(0));
                        res[i] = list.get(0);
                    } else {
                        res[i] = 1;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        int[] rains = {1, 2, 3, 4};
//        System.out.println(Arrays.toString(new Solution().avoidFlood(rains)));
//        int[] rains1 = {1, 2, 0, 0, 2, 1};
//        System.out.println(Arrays.toString(new Solution().avoidFlood(rains1)));
//        int[] rains2 = {1, 2, 0, 1, 2};
//        System.out.println(Arrays.toString(new Solution().avoidFlood(rains2)));
//        int[] rains3 = {69, 0, 0, 0, 69};
//        System.out.println(Arrays.toString(new Solution().avoidFlood(rains3)));
//        int[] rains4 = {10, 20, 20};
//        System.out.println(Arrays.toString(new Solution().avoidFlood(rains4)));
        int[] rains5 = {0, 0, 0, 28663, 0, 0, 0, 0, 0, 0, 0, 0, 95827, 0, 0, 85637, 0, 0, 0, 45506, 95827, 85637, 0, 0, 45506, 0, 0, 0, 28663, 0, 0, 0, 0, 60812, 0, 0, 0, 0, 60812, 0, 0, 0, 0, 0, 0, 0, 0};
        System.out.println(Arrays.toString(new Solution().avoidFlood(rains5)));
    }
}
