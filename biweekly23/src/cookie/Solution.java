package cookie;

import java.util.Arrays;

public class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int max = 0;
        for (int i = 0; i < satisfaction.length; i++) {
            int tempSum = 0;
            for (int j = i, count = 1; j < satisfaction.length; j++, count++) {
                tempSum += (count * satisfaction[j]);
            }
            if (tempSum > max) {
                max = tempSum;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] data = {-2,5,-1,0,3,-3};
        System.out.println(new Solution().maxSatisfaction(data));
    }
}
