/**
 * 最大子序和
 */
public class Solution {
    /**
     * 贪心算法
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int j = 1;
        int max = nums[0];
        int tempSum = nums[0];
        while (j < n) {
            if (tempSum < 0) {
                tempSum = nums[j];
            } else {
                tempSum += nums[j];
            }
            max = Math.max(tempSum, max);
            j++;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(new Solution().maxSubArray(nums));
        int[] nums1 = {-1};
        System.out.println(new Solution().maxSubArray(nums1));
        int[] nums2 = {1};
        System.out.println(new Solution().maxSubArray(nums2));
        int[] nums3 = {-2, -1};
        System.out.println(new Solution().maxSubArray(nums3));
        int[] nums4 = {-2, -3};
        System.out.println(new Solution().maxSubArray(nums4));
    }
}
