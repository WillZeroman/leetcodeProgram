package candy;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> res = new ArrayList<>(candies.length);
        int max = -1;
        for (int t : candies) {
            if (max < t) {
                max = t;
            }
        }
        for (int i = 0; i < candies.length; i++) {
            int val = candies[i];
            res.add(val + extraCandies >= max);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] candies = {2, 3, 5, 1, 3};
        List<Boolean> res = new Solution().kidsWithCandies(candies,3);
        System.out.println(res);
    }
}
