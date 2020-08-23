import java.util.Arrays;

/**
 * dfs
 */
public class Solution {

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int[][] paths = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (paths[i][j] == 0) {
                    dfs(matrix, paths, i, j);
                    display(paths);
                }
            }
        }
        int longestPath = 0;
        for (int i = 0; i < paths.length; i++) {
            for (int j = 0; j < paths[i].length; j++) {
                longestPath = Math.max(longestPath, paths[i][j]);
            }
        }
        return longestPath;
    }

    private void display(int[][] paths) {
        for(int i=0;i<paths.length;i++){
            System.out.println(Arrays.toString(paths[i]));
        }
        System.out.println();
    }

    private void dfs(int[][] matrix, int[][] paths, int i, int j) {
        if (paths[i][j] != 0) {
            return;
        }
        int row = matrix.length;
        int column = matrix[0].length;
        int currentValue = matrix[i][j];
        int upPath = 0;
        if (i - 1 >= 0 && currentValue < matrix[i - 1][j]) {
            dfs(matrix, paths, i - 1, j);
            upPath = paths[i - 1][j];
        }
        int downPath = 0;
        if (i + 1 < row && currentValue < matrix[i + 1][j]) {
            dfs(matrix, paths, i + 1, j);
            downPath = paths[i + 1][j];
        }
        int leftPath = 0;
        if (j - 1 >= 0 && currentValue < matrix[i][j - 1]) {
            dfs(matrix, paths, i, j - 1);
            leftPath = paths[i][j - 1];
        }
        int rightPath = 0;
        if (j + 1 < column && currentValue < matrix[i][j + 1]) {
            dfs(matrix, paths, i, j + 1);
            rightPath = paths[i][j + 1];
        }
        int maxPath = Math.max(Math.max(upPath, downPath), Math.max(leftPath, rightPath));
        paths[i][j] = maxPath + 1;
    }

    public static void main(String[] args) {
        int[][] nums = {
                {3, 4, 5},
                {3, 2, 6},
                {2, 2, 1}
        };
        System.out.println(new Solution().longestIncreasingPath(nums));
    }
}
