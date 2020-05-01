package stonegame;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        int alice = 0;
        int bob = 0;
        boolean turn = true;
        for (int i = 0; i < n; ) {
            // get one
            List<Integer> list = new ArrayList<>();
            list.add(stoneValue[i]);
            if (i + 1 < n) {
                list.add(stoneValue[i + 1]);
            }
            if (i + 2 < n) {
                list.add(stoneValue[i + 2]);
            }
            int res = computeMaxValue(list);
            if (turn) {
                for (int j = 0; j < res; j++) {
                    alice += stoneValue[i+j];
                }
            } else {
                for (int j = 0; j < res; j++) {
                    bob += stoneValue[i+j];
                }
            }
            turn = !turn;
            i += res;
        }
        if (alice < bob) {
            return "Bob";
        } else if (alice > bob) {
            return "Alice";
        } else {
            return "Tie";
        }
    }

    private int computeMaxValue(List<Integer> list) {
        int index = 1;
        if (list.size() == 1) {
            return index;
        } else if (list.size() == 2) {
            int tempValue = list.get(0);
            int totalValue = list.get(0) + list.get(1);
            if (tempValue < totalValue) {
                return 2;
            } else {
                return 1;
            }
        } else {
            // get three
            index = 3;
            int maxValue = list.get(0) + list.get(1) + list.get(2);
            int tempValue = list.get(0) + list.get(1);
            if (tempValue > maxValue) {
                index = 2;
                maxValue = tempValue;
            }
            tempValue = list.get(0);
            if (tempValue > list.get(1) + list.get(2) && tempValue + list.get(2) > list.get(1)) {
                if (tempValue > maxValue) {
                    index = 1;
                }
            }
            return index;
        }
    }

    public static void main(String[] args) {
        int[] data = {1,2,3,-1,-2,-3,7};
        System.out.println(new Solution().stoneGameIII(data));
    }
}
