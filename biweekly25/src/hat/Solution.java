package hat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 回溯法 超时
 * dp 压缩
 */
public class Solution {
    private long num = 0;

    public int numberWays(List<List<Integer>> hats) {
        boolean[] visitedHat = new boolean[41];
        dfs(hats, visitedHat, 0);
        return (int)(num % (Math.pow(10,9) + 7));
    }

    private void dfs(List<List<Integer>> hats, boolean[] visitedHat, int index) {
        if (index == hats.size()) {
            num++;
            return;
        }
        List<Integer> canChoose = hats.get(index);
        for (int chooseIndex = 0; chooseIndex < canChoose.size(); chooseIndex++) {
            int val = canChoose.get(chooseIndex);
            if (!visitedHat[val]) {
                visitedHat[val] = true;
                dfs(hats, visitedHat, index + 1);
                visitedHat[val] = false;
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> hats = new ArrayList<>();
        hats.add(Arrays.asList(1,2,3));
        hats.add(Arrays.asList(2,3,5,6));
        hats.add(Arrays.asList(1,3,7,9));
        hats.add(Arrays.asList(1,8,9));
        hats.add(Arrays.asList(2,5,7));
        System.out.println(new Solution().numberWays(hats));
        System.out.println(10 ^ 9 + 7);
    }
}
