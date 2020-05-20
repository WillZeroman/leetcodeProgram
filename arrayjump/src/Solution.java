import java.util.Arrays;

public class Solution {
    /**
     * 超时
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return 0;
        }
        int[] steps = new int[n];
        for (int i = 0; i < n - 1; i++) {
            int val = nums[i];
            for (int j = 1; j <= val && i + j < n; j++) {
                if (steps[i + j] == 0) {
                    steps[i + j] = steps[i] + 1;
                } else {
                    steps[i + j] = Math.min(steps[i + j], steps[i] + 1);
                }
            }
            System.out.println(Arrays.toString(steps));
        }
        return steps[n - 1];
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(new Solution().jump(nums));
        int[] nums1 = {2, 1, 3};
        System.out.println(new Solution().jump(nums1));
    }
}
