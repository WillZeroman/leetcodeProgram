import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public int[] divingBoard(int shorter, int longer, int k) {
        if (k == 0) {
            return new int[]{};
        }
        if (shorter == longer) {
            return new int[]{shorter * k};
        }
        List<Integer> list = new ArrayList<>(k);
        for (int i = 0; i <= k; i++) {
            int tmp = shorter * (k - i) + longer * i;
            list.add(tmp);
        }
        System.out.println(list.size());
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().divingBoard(2,1118596, 979)));
        System.out.println(Arrays.toString(new Solution().divingBoard(1,2, 3)));
    }
}
