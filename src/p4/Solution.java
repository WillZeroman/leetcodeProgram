package p4;

public class Solution {
    public int domino(int n, int m, int[][] broken) {
        int[][] map = new int[n][m];
        for(int i=0;i<broken.length;i++)
        {
            map[broken[i][0]][broken[i][1]] = 1;
        }
        int maxRes = 0;


        return 0;
    }

    public static void main(String[] args) {

    }
}
