package submat;

public class Solution {
    public int numSubmat(int[][] mat) {
        if (mat.length == 0) {
            return 0;
        }
        int rows = mat.length;
        int columns = mat[0].length;
        int nums = rows * columns;
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                int subRows = i + 1;
                int subColumns = j + 1;
                for (int k = 0; k < nums; k++) {
                    int tmpRow = k / columns;
                    int tmpColumn = k % columns;
                    if (tmpRow + subRows <= rows && tmpColumn + subColumns <= columns) {
                        // is valid
                        count += valid(tmpRow, tmpColumn, subRows, subColumns, mat) ? 1 : 0;
                    }
                }
            }
        }
        return count;
    }

    private boolean valid(int tmpRow, int tmpColumn, int subRows, int subColumns, int[][] mat) {
        for (int m = 0; m < subRows; m++) {
            for (int n = 0; n < subColumns; n++) {
                if (mat[m + tmpRow][n + tmpColumn] != 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] mat = {{1, 0, 1}, {1, 1, 0}, {1, 1, 0}};
        System.out.println(new Solution().numSubmat(mat));
    }
}
