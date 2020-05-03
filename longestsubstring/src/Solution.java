import java.util.HashMap;
import java.util.Map;

/**
 * 滑动窗口
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int longestLen = 0;
        int start = 0;
        int end = 0;
        Map<Character, Integer> map = new HashMap<>(s.length());
        while (end < s.length()) {
            char ch = s.charAt(end);
            if (map.containsKey(ch)) {
                if (longestLen < map.size()) {
                    longestLen = map.size();
                }
                int index = map.get(ch);
                for (int i = start; i <= index; i++) {
                    map.remove(s.charAt(i));
                }
                start = index + 1;
            }
            map.put(ch, end);
            end ++;
        }
        if (longestLen < map.size()) {
            longestLen = map.size();
        }

        return longestLen;
    }

    public static void main(String[] args) {
        //String s = "abcabcbb";
        String s = "pwwkew";
        int res = new Solution().lengthOfLongestSubstring(s);
        System.out.println(res);
    }
}
