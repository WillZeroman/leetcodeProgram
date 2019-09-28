package medianoftwosortedarrays;

public class Solution {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        return (m+n)/2;
    }

    public static void main(String[] args) {
        int[] nums1 = {};
        int[] nums2 = {};
        double res = findMedianSortedArrays(nums1,nums2);
        System.out.println(res);
    }
}
