package medianoftwosortedarrays;

public class Solution {
    /**
     * 合并后在查找
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int i = 0;
        int j = 0;
        int k = 0;
        int[] mergedNums = new int[m + n];
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                mergedNums[k++] = nums1[i++];
            } else {
                mergedNums[k++] = nums2[j++];
            }
        }
        while (i < m) {
            mergedNums[k++] = nums1[i++];
        }
        while (j < n) {
            mergedNums[k++] = nums2[j++];
        }
        if ((m + n) % 2 == 0) {
            int second = (m + n) / 2;
            int first = second - 1;
            return (mergedNums[first] + mergedNums[second]) / 2.0;
        } else {
            int mid = (m + n) / 2;
            return mergedNums[mid];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1,3};
        int[] nums2 = {2,4};
        double res = findMedianSortedArrays(nums1, nums2);
        System.out.println(res);
    }
}
