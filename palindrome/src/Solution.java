/**
 * 判断是否为回文数
 */
public class Solution {

    /**
     * 字符串方法
     *
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        StringBuilder sb = new StringBuilder(x + "");
        return sb.toString().equals(sb.reverse().toString());
    }

    /**
     * 非字符串方法
     *
     * @param x
     * @return
     */
    public boolean isPalindrome_nostring(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int reservNum = 0;
        while (x > reservNum) {
            reservNum = reservNum * 10 + x % 10;
            x /= 10;
        }
        return x == reservNum || x == reservNum / 10;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isPalindrome_nostring(121));
        System.out.println(new Solution().isPalindrome_nostring(12321));
        System.out.println(new Solution().isPalindrome_nostring(0));
        System.out.println(new Solution().isPalindrome_nostring(10));
        System.out.println(new Solution().isPalindrome_nostring(-121));
    }
}
