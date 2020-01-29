package zigzig;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * z
 */
public class Solution {
    /**
     * space o(n^2) time o(n)
     */
    public String convert(String s, int numRows) {
        int len = s.length();
        if (numRows == 1) {
            return s;
        }
        int column = (len / (numRows + numRows - 2) + 1) * (numRows - 1);
        char[][] arr = new char[numRows][column];
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            int r = i % (numRows + numRows - 2);
            int row = r;
            if (row >= numRows) {
                row = numRows - 2 - (row - numRows);
            }
            int c = i / (numRows + numRows - 2) * (numRows - 1);
            if (r >= numRows) {
                c = c + r - numRows + 1;
            }
            arr[row][c] = ch;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (0 != arr[i][j]) {
                    sb.append(arr[i][j]);
                }
            }
        }
        return sb.toString();
    }

    private void print(char[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }

    /**
     *
     * @param s
     * @param numRows
     * @return
     */
    public String convert2(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        int len = s.length();
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, len); i++) {
            rows.add(new StringBuilder());
        }

        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            int index = i % (numRows + numRows - 2);
            if (index >= numRows) {
                index = numRows - 2 - (index - numRows);
            }
            rows.get(index).append(ch);
        }

        StringBuilder res = new StringBuilder();
        for (StringBuilder sb : rows) {
            res.append(sb);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String r1 = new Solution().convert("PAYPALISHIRING", 4);
        System.out.println(r1.length());
        System.out.println(r1);
        String r2 = new Solution().convert2("PAYPALISHIRING", 4);
        System.out.println(r2);
    }
}
