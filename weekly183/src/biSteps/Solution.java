package biSteps;

public class Solution {
    public int numSteps(String s) {
        int count = 0;
        int len = s.length();
        boolean flag = false;
        while (len > 1) {
            char ch = s.charAt(len - 1);
            if (ch == '1') {
                if (flag) {
                    count += 1;
                } else {
                    count += 2;
                    flag = true;
                }
            } else {
                if (flag) {
                    count += 2;
                    flag = true;
                } else {
                    count += 1;
                }
            }
            len--;
        }
        if (flag) {
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numSteps("1111110011101010110011100100101110010100101110111010111110110010"));
        System.out.println(new Solution().numSteps("1101"));
        System.out.println(new Solution().numSteps("10"));
        System.out.println(new Solution().numSteps("1"));
    }
}
