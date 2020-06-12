/**
 * 斐波拉西数列
 * 递归求解，超时
 * 动态规划
 * 矩阵快速幂
 * 通项公式
 */
public class Solution {
    /**
     * Time: O(2^n)
     * Space: O(n)
     * @param n
     * @return
     */
    public int climbStairs_old(int n) {
        if (n == 2) {
            return 2;
        }
        if (n == 1) {
            return 1;
        }
        return climbStairs(n - 2) + climbStairs(n - 1);
    }

    /**
     * 滚动数组
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n == 2) {
            return 2;
        }
        if (n == 1) {
            return 1;
        }
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            int three = first + second;
            first = second;
            second = three;
        }
        return second;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().climbStairs(3));
        System.out.println(new Solution().climbStairs(5));
        System.out.println(new Solution().climbStairs(45));
    }
}
