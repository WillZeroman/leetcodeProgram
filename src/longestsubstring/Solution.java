package longestsubstring;

import java.util.HashMap;
import java.util.Map;

/**
 * find the longest substring without repeating characters
 * <p>
 * my solution:
 * 遍历字符串，从小打到，找到不重复的。
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int i = 0;
        int start = 0;
        int max = -1;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        while (i < len && max < (len - i + map.size())) {
            char ch = s.charAt(i);
            Integer index = map.get(ch);
            if (index != null) {
                int tempMax = i - start;
                max = max > tempMax ? max : tempMax;
                map.clear();
                start = index + 1;
                for (int j = start; j < i; j++) {
                    map.put(s.charAt(j), j);
                }
            }
            map.put(ch, i);
            i++;
        }
        int tempMax = i - start;
        max = max > tempMax ? max : tempMax;
        return max;
    }

    /**
     * time : O(n)
     * space : O(n)
     * 两个指针
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring1(String s) {
        int len = s.length();
        int max = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int start = 0;
        int j = 0;
        while (j < len) {
            char ch = s.charAt(j);
            Integer index = map.get(ch);
            if (index != null) {
                //contains
                start = Math.max(start,index + 1);
            }
            max = Math.max(max,j-start + 1);
            map.put(ch,j);
            j++;
        }

        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //System.out.println(solution.lengthOfLongestSubstring1("abcabcabcccc"));
        //System.out.println(solution.lengthOfLongestSubstring1("bbbbbbbbbb"));
        //System.out.println(solution.lengthOfLongestSubstring1("pwwkew"));
        System.out.println(solution.lengthOfLongestSubstring1("abba"));
        //System.out.println(solution.lengthOfLongestSubstring1("dvdf"));
    }
}
