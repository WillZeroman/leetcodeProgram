package p3;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public boolean robot(String command, int[][] obstacles, int x, int y) {
        int sx = 0;
        int sy = 0;
        int flag = 0;
        int count = 0;
        int len = command.length();
        List<int[]> obstacleList = new LinkedList<>();
        for(int i=0;i<obstacles.length;i++)
        {
            obstacleList.add(obstacles[i]);
        }
        while (flag == 0) {
            if (sx == x && sy == y) {
                flag = 1;
                break;
            }
            if (sx > x || sy > y) {
                flag = 2;
                break;
            }
            if(!obstacleList.isEmpty())
            {
                Iterator<int[]> it = obstacleList.iterator();
                while(it.hasNext())
                {
                    int[] array = it.next();
                    if (array[0] == sx && array[1] == sy) {
                        return false;
                    }
                    if(sx > array[0] || sy> array[1])
                    {
                        it.remove();
                    }
                }
            }

            char ch = command.charAt(count);
            if (ch == 'U') {
                sy++;
            } else {
                sx++;
            }
            count++;
            if (count == len) {
                count = 0;
            }
        }
        return flag == 1;
    }

    public static void main(String[] args) {
        String command = "URR";
        int[][] obstacles = new int[1000][2];
        for(int i=0;i<1000;i++)
        {
            obstacles[i] = new int[]{i+1,0};
        }
        obstacles = new int[][]{};
        int x = Integer.MAX_VALUE/2;
        int y = Integer.MAX_VALUE/2;
        long start = System.currentTimeMillis();
        boolean res = new Solution().robot(command, obstacles, x, y);
        long end = System.currentTimeMillis();
        System.out.println(res);
        System.out.println(end-start);
    }
}
