package arithmetic;

import java.util.Arrays;

public class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int diff = arr[1] - arr[0];
        for (int i = 2; i < arr.length; i++) {
            int tmpDiff = arr[i] - arr[i - 1];
            if (tmpDiff != diff) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = {3,5,1};
        System.out.println(new Solution().canMakeArithmeticProgression(arr));
    }
}
