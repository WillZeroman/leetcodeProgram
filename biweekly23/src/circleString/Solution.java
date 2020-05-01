package circleString;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean canConstruct(String s, int k) {
        if (s.length() < k) {
            return false;
        }
        Map<Character, Integer> data = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (data.containsKey(ch)) {
                data.put(ch, data.get(ch) + 1);
            } else {
                data.put(ch, 1);
            }
        }
        int count = 0;
        for (Integer i : data.values()) {
            if (i%2 ==1) {
                count++;
            }
        }
        return count <= k;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().canConstruct("annabelle",3));
        System.out.println(new Solution().canConstruct("leetcode",3));
        System.out.println(new Solution().canConstruct("true",4));
        System.out.println(new Solution().canConstruct("cxayrgpcctwlfupgzirmazszgfiusitvzsnngmivctprcotcuutfxdpbrdlqukhxkrmpwqqwdxxrptaftpnilfzcmknqljgbfkzuhksxzplpoozablefndimqnffrqfwgaixsovmmilicjwhppikryerkdidupvzdmoejzczkbdpfqkgpbxcrxphhnxfazovxbvaxyxhgqxcxirjsryqxtreptusvupsstylpjniezyfokbowpbgxbtsemzsvqzkbrhkvzyogkuztgfmrprz"
            ,5));
    }
}
