public class Solution {

    /**
     * @param A
     * @return
     */
    public int maxScoreSightseeingPair(int[] A) {
        int i = 0;
        int j = 1;
        int k = 2;
        int max = A[i] + A[j] + i - j;
        for (; k < A.length; k++) {
            if (A[k] > A[i] && A[k] > A[j]) {
                int tempSwapI = A[k] + A[j] + j - k;
                int tempSwapJ = A[k] + A[i] + i - k;
                if (tempSwapI > tempSwapJ && tempSwapI > max) {
                    i = k;
                    max = tempSwapI;
                }
                if (tempSwapJ > tempSwapI && tempSwapJ > max) {
                    j = k;
                    max = tempSwapJ;
                }
            } else if (A[k] > A[i]) {
                int tempSwapI = A[k] + A[j] + j - k;
                if (tempSwapI > max) {
                    i = k;
                    max = tempSwapI;
                }
            } else if (A[k] > A[j]) {
                int tempSwapJ = A[k] + A[i] + i - k;
                if (tempSwapJ > max) {
                    j = k;
                    max = tempSwapJ;
                }
            } else {

            }
        }
        return max;
    }

    public int maxScoreSightseeingPair_bad(int[] A) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                int temp = A[i] + A[j] + i - j;
                if (temp > max) {
                    max = temp;
                }
            }
        }
        return max;
    }

    public int maxScoreSightseeingPair_best(int[] A) {
        int max = 0;
        int mx = A[0] + 0;
        for (int j = 1; j < A.length; j++) {
            max = Math.max(max, mx + A[j] - j);
            mx = Math.max(mx, A[j] + j);
        }
        return max;
    }

    public static void main(String[] args) {
//        int[] a = {8, 1, 5, 2, 6};
//        System.out.println(new Solution().maxScoreSightseeingPair(a));
//        int[] a1 = {1, 2, 3, 4, 5};
//        System.out.println(new Solution().maxScoreSightseeingPair(a1));
//        int[] a2 = {5, 4, 3, 2, 1};
//        System.out.println(new Solution().maxScoreSightseeingPair(a2));
//        int[] a3 = {1, 1, 5, 1, 4, 3, 2, 6};
//        System.out.println(new Solution().maxScoreSightseeingPair(a3));
        int[] a4 = {4, 3, 2, 5, 1, 8, 10};
        System.out.println(new Solution().maxScoreSightseeingPair_best(a4));
    }
}
