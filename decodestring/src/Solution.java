import java.util.Stack;

public class Solution {
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();

        char num = ' ';
        StringBuilder tempStr = new StringBuilder();
        Stack<Character> stackNum = new Stack<>();
        Stack<String> stackStr = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '[') {
                stackNum.push(num);
                stackStr.push(tempStr.toString());
                tempStr = new StringBuilder();
            } else if ('0' <= ch && ch <= '9') {
                num = ch;
            } else if ('a' <= ch && ch <= 'z') {
                tempStr.append(ch);
            } else if (ch == ']') {
                char TmpNum = stackNum.pop();
                String str = stackStr.pop();
                int intNum = TmpNum - '0';
                for (int j = 0; j < intNum; j++) {
                    sb.append(tempStr);
                }
                if (!"".equals(str)) {
                    sb.insert(0, str);
                }
                tempStr = new StringBuilder();
            }
        }
        sb.append(tempStr);
        return sb.toString();
    }

    public static void main(String[] args) {
        //System.out.println(new Solution().decodeString("3[a]2[bc]"));
        System.out.println(new Solution().decodeString("3[a2[c]]"));
        //System.out.println(new Solution().decodeString("2[abc]3[cd]ef"));
    }
}
