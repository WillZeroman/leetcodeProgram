package twosum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    /**
     * 时间复杂度： O（n^2） 两次循环
     */
    public int[] twoSum(int[] nums, int target) {
        if (nums.length < 2) {
            return null;
        }
        int[] res = new int[2];
        boolean found = false;
        for (int i = 0; i < nums.length - 1 && !found; i++) {
            for (int j = i + 1; j < nums.length && !found; j++) {
                if (nums[i] + nums[j] == target) {
                    res[0] = i;
                    res[1] = j;
                    found = true;
                }
            }
        }
        return res;
    }

    /**
     * hashmap 做映射 时间复杂度：O（n）
     */
    public int[] twoSum1(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            numMap.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int first = nums[i];
            int second = target - first;
            Integer secondIndex = numMap.get(second);
            if (secondIndex != null && secondIndex != i) {
                int[] res = new int[2];
                res[0] = i;
                res[1] = secondIndex;
                return res;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] res = new Solution().twoSum1(nums, target);
        System.out.println(Arrays.toString(res));
    }
}
