public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] a = {3, 2, 1, 2, 1, 7};
        int res = s.minIncrementForUnique(a);
        System.out.println(res);

        int[] a1 = {1, 2, 2};
        res = s.minIncrementForUnique(a1);
        System.out.println(res);
    }
}
