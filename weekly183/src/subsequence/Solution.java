package subsequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (Integer i : nums) {
            sum += i;
        }
        List<Integer> res = new ArrayList<>();
        int resSum = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            int last = nums[i];
            resSum += last;
            res.add(last);
            if (resSum > sum - resSum) {
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] data = {6};
        System.out.println(new Solution().minSubsequence(data));
    }
}
