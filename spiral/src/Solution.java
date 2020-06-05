import java.util.Arrays;

public class Solution {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[0];
        }
        int m = matrix.length;
        int n = matrix[0].length;

        int len = m * n;
        int[] res = new int[len];
        boolean[][] visited = new boolean[m][n];
        int p = 0;
        int i = 0;
        int j = 0;
        int direct = 0;
        while (p < len) {
            boolean change = false;
            if (j == n) {
                direct++;
                change = true;
                j = n - 1;
            }
            if (j < 0) {
                direct++;
                j = 0;
                change = true;
            }
            if (i == m) {
                direct++;
                i = m - 1;
                change = true;
            }
            if (i < 0) {
                direct++;
                i = 0;
                change = true;
            }
            if (!change && visited[i][j]) {
                if (direct == 0) {
                    j--;
                } else if (direct == 1) {
                    i--;
                } else if (direct == 2) {
                    j++;
                } else {
                    i++;
                }
                direct++;
                change = true;
                direct %= 4;
            }

            if (!change) {
                res[p] = matrix[i][j];
                visited[i][j] = true;
                p++;
            }

            if (direct == 0) {
                j++;
            } else if (direct == 1) {
                i++;
            } else if (direct == 2) {
                j--;
            } else {
                i--;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        //int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        //int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] matrix = {{1, 2, 3}};
        System.out.println(Arrays.toString(new Solution().spiralOrder(matrix)));
    }
}
