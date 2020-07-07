import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 1)暴力解法: 先以s.length 的偶数来判断该子串是否为有效的子串
 *            n-2 比较
 *            n-4 比价
 */
public class Solution {
    public int longestValidParentheses_bad(String s) {
        int longest = 0;
        Deque<Character> stack = new ArrayDeque<Character>();
        int i = 0;
        int tempLongest = 0;
        for (; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                if (stack.isEmpty()) {
                    longest = Math.max(longest, tempLongest);
                    tempLongest = 0;
                } else {
                    stack.pop();
                    tempLongest += 2;
                }
            }
        }

        return Math.max(longest, tempLongest);
    }

    /**
     * 动态规划
     * @param s
     * @return
     */
    public int longestValidParentheses(String s){
        int max = 0;
        int[] dp = new int[s.length()];
        for(int i=1;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == ')'){
                if(ch == '('){
                    dp[i] = (i>=2 ? dp[i-2] : 0) + 2;
                }else if(i-dp[i-1] > 0 && s.charAt(i-dp[i-1]-1) == '('){
                    dp[i] = dp[i-1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                max = Math.max(max,dp[i]);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestValidParentheses(""));
        System.out.println(new Solution().longestValidParentheses("(()"));
        System.out.println(new Solution().longestValidParentheses(")()())"));
//        System.out.println(new Solution().longestValidParentheses("()())"));
//        System.out.println(new Solution().longestValidParentheses("((())))"));
        System.out.println(new Solution().longestValidParentheses("()(()"));
        System.out.println(new Solution().longestValidParentheses("()(())"));
    }
}
