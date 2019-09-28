package palindromic;

/**
 * find the longest palindromic in a string
 */
public class Solution {
    public static String longestPalindrome(String s) {
        int len = s.length();
        String longestStr = "";
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            StringBuilder temp = new StringBuilder();
            temp.append(ch);

            if (i + 1 < len && ch == s.charAt(i + 1)) {
                temp.append(ch);
                for (int j = 1; i - j >= 0 && i + 1 + j < len; j++) {
                    if (s.charAt(i - j) == s.charAt(i + 1 + j)) {
                        temp.append(s.charAt(i - j));
                        temp.insert(0, s.charAt(i - j));
                    } else {
                        break;
                    }
                }
            }
            if (temp.length() > longestStr.length()) {
                longestStr = temp.toString();
            }

            temp = new StringBuilder();
            temp.append(ch);
            for (int j = 1; i - j >= 0 && i + j < len; j++) {
                if (s.charAt(i - j) == s.charAt(i + j)) {
                    temp.append(s.charAt(i + j));
                    temp.insert(0, s.charAt(i + j));
                } else {
                    break;
                }
            }

            if (temp.length() > longestStr.length()) {
                longestStr = temp.toString();
            }
        }
        return longestStr;
    }

    public static void main(String[] args) {
        String res = longestPalindrome("babad");
        System.out.println(res);
        res = longestPalindrome("cbbd");
        System.out.println(res);
        res = longestPalindrome("a");
        System.out.println(res);
        res = longestPalindrome("ccc");
        System.out.println(res);
        res = longestPalindrome("tattarrattat");
        System.out.println(res);
    }
}
