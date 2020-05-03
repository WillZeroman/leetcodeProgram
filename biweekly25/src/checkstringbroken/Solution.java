package checkstringbroken;

import java.util.Arrays;

public class Solution {
    public boolean checkIfCanBreak(String s1, String s2) {
        byte[] b1 = s1.getBytes();
        byte[] b2 = s2.getBytes();
        Arrays.sort(b1);
        Arrays.sort(b2);
        if (b1[0] - b2[0] > 0) {
            int i = 0;
            for (; i < b1.length; i++) {
                if (b1[i] >= b2[i]) {
                    continue;
                } else {
                    break;
                }
            }
            return i == b1.length;
        } else if (b1[0] - b2[0] < 0) {
            int i = 0;
            for (; i < b1.length; i++) {
                if (b1[i] <= b2[i]) {
                    continue;
                } else {
                    break;
                }
            }
            return i == b1.length;
        } else {
            int i = 0;
            for (; i < b1.length; i++) {
                if (b1[i] >= b2[i]) {
                    continue;
                } else {
                    break;
                }
            }
            if (i != b1.length) {
                for (i = 0; i < b1.length; i++) {
                    if (b1[i] <= b2[i]) {
                        continue;
                    } else {
                        break;
                    }
                }
            }
            return i == b1.length;
        }
    }

    public static void main(String[] args) {
        //        System.out.println(new Solution().checkIfCanBreak("abc", "xya"));
        //        System.out.println(new Solution().checkIfCanBreak("abe", "acd"));
        //        System.out.println(new Solution().checkIfCanBreak("leetcodee", "interview"));
        System.out
            .println(new Solution().checkIfCanBreak("bxfowqvnrhuzwqohquamvszkvunb", "xjegbjccjjxfnsiearbsgsofywtq"));
    }
}
