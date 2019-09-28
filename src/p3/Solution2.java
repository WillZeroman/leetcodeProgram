package p3;

public class Solution2 {

    public boolean robot(String command, int[][] obstacles, int x, int y) {
        int len = command.length();
        int uNum = 0;
        int rNum = 0;
        for (int i = 0; i < len; i++) {
            if (command.charAt(i) == 'U') {
                uNum++;
            } else {
                rNum++;
            }
        }
        //check obstacle
        for (int i = 0; i < obstacles.length; i++) {
            int[] array = obstacles[i];
            if (canPass(command, uNum, rNum, array)) {
                return false;
            }
        }
        return canPass(command, uNum, rNum, new int[] {x, y});
    }

    private boolean canPass(String command, int uNum, int rNum, int[] array) {
        int x = array[0];
        int y = array[1];
        int minNum = Math.min(x / rNum, y / uNum);
        int nx = minNum * rNum;
        int ny = minNum * uNum;

        //from (nx,ny) to (x,y)
        int count = 0;
        while (true) {
            if (nx == x && ny == y) {
                return true;
            }
            if (nx > x || ny > y) {
                return false;
            }
            char ch = command.charAt(count % command.length());
            if (ch == 'U') {
                ny++;
            } else {
                nx++;
            }
            count++;
        }
    }

    public static void main(String[] args) {
        String command = "URR";
        int[][] obstacles = new int[][] {{2,2}};
        int x = 3;
        int y = 2;
        long start = System.currentTimeMillis();
        boolean res = new Solution2().robot(command, obstacles, x, y);
        long end = System.currentTimeMillis();
        System.out.println(res);
        System.out.println(end - start);
    }
}
