package p2;

import java.util.Arrays;

public class Solution {
    public int[] fraction(int[] cont) {
        int x = 1;
        int y = cont[cont.length - 1];
        for (int i = cont.length - 1; i > 0; i--) {
            x = y * cont[i - 1] + x;
            y = y;
            int t = x;
            x = y;
            y = t;
            int f = getFra(x, y);
            x /= f;
            y /= f;
        }
        return new int[] {y, x};
    }

    private int getFra(int x, int y) {
        int min = Math.min(x, y);
        for (int i = min; min >= 1; i--) {
            if (x % i == 0 && y % i == 0) {
                return i;
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        int[] g1 = {1, 2, 3};
        int[] t1 = new Solution().fraction(g1);
        System.out.println(Arrays.toString(t1));

        int[] g2 = {3, 2, 0, 2};
        int[] t2 = new Solution().fraction(g2);
        System.out.println(Arrays.toString(t2));
        int[] g3 = {0, 0, 3};
        int[] t3 = new Solution().fraction(g3);
        System.out.println(Arrays.toString(t3));
    }
}

