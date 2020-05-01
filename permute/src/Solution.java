import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    private List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            List<Integer> tempPath = new ArrayList<>(len);
            boolean[] visited = new boolean[len];
            dfs(tempPath, visited, i, nums);
        }
        return res;
    }

    private void dfs(List<Integer> tempPath, boolean[] visited, int i, int[] nums) {
        visited[i] = true;
        tempPath.add(i);
        int len = nums.length;
        if (tempPath.size() == len) {
            List<Integer> tempRes = new ArrayList<>(len);
            tempPath.forEach(j -> {
                tempRes.add(nums[j]);
            });
            res.add(tempRes);
            return;
        }
        for (int j = 0; j < len; j++) {
            if (j != i && !visited[j]) {
                dfs(tempPath, visited, j, nums);
                int index = tempPath.remove(tempPath.size() - 1);
                visited[index] = false;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        List<List<Integer>> res = new Solution().permute(nums);
        res.forEach(System.out::println);
        System.out.println(res.size());
    }
}
