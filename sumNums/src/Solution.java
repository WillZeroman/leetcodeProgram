public class Solution {
    public int sumNums(int n) {
        if (n == 1) {
            return 1;
        }
        return n + sumNums(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().sumNums(3));
        System.out.println(new Solution().sumNums(9));
    }
}
