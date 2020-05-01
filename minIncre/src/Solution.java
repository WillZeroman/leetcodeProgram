import java.util.Arrays;

public class Solution {
    public int minIncrementForUnique(int[] A) {
        if (A.length == 0) {
            return 0;
        }
        int count = 0;
        Arrays.sort(A);
        int start = A[0];
        for (int i = 1; i < A.length; i++) {
            if (A[i] <= start) {
                count += (start - A[i] + 1);
                start++;
            } else {
                start = A[i];
            }
        }

        return count;
    }
}
