package maxdif;

public class Solution {

    public int maxDiff(int num) {
        String numString = String.valueOf(num);
        char ch = numString.charAt(0);
        int max = num;
        if (ch != '9') {
            String newString = numString.replace(ch + "", "9");
            max = Integer.parseInt(newString);
        } else {
            for (int i = 1; i < numString.length(); i++) {
                char tempCh = numString.charAt(i);
                if (tempCh != '9') {
                    String newString = numString.replace(tempCh + "", "9");
                    max = Integer.parseInt(newString);
                    break;
                }
            }
        }

        int min = num;
        if (ch != '1') {
            String newString = numString.replace(ch + "", "1");
            min = Integer.parseInt(newString);
        } else {
            for (int i = 1; i < numString.length(); i++) {
                char tempCh = numString.charAt(i);
                if (tempCh != '0') {
                    String newString = numString.replace(tempCh + "", "0");
                    if (!newString.startsWith("0")) {
                        min = Integer.parseInt(newString);
                        break;
                    }
                }
            }
        }

        return max - min;
    }

    public static void main(String[] args) {
        int num = 9999;
        System.out.println(new Solution().maxDiff(num));
        System.out.println(new Solution().maxDiff(5));
        System.out.println(new Solution().maxDiff(555));
        System.out.println(new Solution().maxDiff(123456));
        System.out.println(new Solution().maxDiff(1000));
        System.out.println(new Solution().maxDiff(9288));
    }
}
