import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    /**
     * O (n^2)
     */
    public int subarraysDivByK(int[] A, int K) {
        int count = 0;

        for (int i = 0; i < A.length; i++) {
            int sum = 0;
            for (int j = i; j < A.length; j++) {
                sum += A[j];
                sum %= K;
                if (sum == 0) {
                    count++;
                }
            }
        }

        return count;
    }

    public int subarraysDivByK_best(int[] A, int K) {
        int[] p = new int[A.length];
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            sum %= K;
            sum += K;
            sum %= K;
            p[i] = sum;
        }
        Map<Integer, Integer> map = new HashMap<>(K);
        for (int tmp : p) {
            tmp %= K;
            if (map.containsKey(tmp)) {
                map.put(tmp, map.get(tmp) + 1);
            } else {
                map.put(tmp, 1);
            }
        }
        int count = 0;
        for (Integer key : map.keySet()) {
            int val = map.get(key);
            if (key == 0) {
                count += val;
            }
            int tmpCount = val * (val - 1) / 2;
            count += tmpCount;
        }

        return count;
    }

    public static void main(String[] args) {
        //        int[] a = {4, 5, 0, -2, -3, 1};
        int[] a = {4, 5, 0, -2, -3, 1};
        int k = 5;
        System.out.println(new Solution().subarraysDivByK_best(a, k));
    }
}
