package runningsum;

import java.util.Arrays;

public class Solution {
    public int[] runningSum(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        int sum = 0;
        for(int i=0;i<len;i++){
            sum +=nums[i];
            res[i] = sum;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        System.out.println(Arrays.toString(new Solution().runningSum(nums)));
        int[] nums1 = {1,1,1,1,1};
        System.out.println(Arrays.toString(new Solution().runningSum(nums1)));
        int[] nums2 = {3,1,2,10,1};
        System.out.println(Arrays.toString(new Solution().runningSum(nums2)));
    }
}
