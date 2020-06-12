/**
 * 最优解，滚动数组
 */
public class Solution {

    /**
     * 递归方法
     * @param num
     * @return
     */
    public int translateNum(int num) {
        if (num < 10) {
            return 1;
        }
        if (num < 100) {
            if (num < 26) {
                return 2;
            } else {
                return 1;
            }
        }

        int tempNum1 = num / 10;
        int sum = translateNum(tempNum1);
        int tempNum2 = num / 100;
        int tempnum2yu = num % 100;
        if (10 <= tempnum2yu && tempnum2yu < 26) {
            sum += translateNum(tempNum2);
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().translateNum(12258));
        System.out.println(new Solution().translateNum(1));
        System.out.println(new Solution().translateNum(26));
        System.out.println(new Solution().translateNum(100));
        System.out.println(new Solution().translateNum(506));
    }
}
