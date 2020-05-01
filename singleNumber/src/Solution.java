import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

public class Solution {
    public int[] singleNumbers(int[] nums) {
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (max < nums[i]) {
                max = nums[i];
            }
        }
        BitSet bitSet = new BitSet(max);
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            boolean oldValue = bitSet.get(n);
            bitSet.set(n, !oldValue);
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length && res.size() < 2; i++) {
            if (bitSet.get(nums[i])) {
                res.add(nums[i]);
            }
        }
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }

    public static void main(String[] args) {
        int[] nums = {1,10,4,1,4,3,3};
//        int[] res = new Solution().singleNumbers(nums);
//        System.out.println(Arrays.toString(res));

        int r = 0;
        for (int t : nums) {
            r ^= t;
        }
        System.out.println(r);
    }
}
