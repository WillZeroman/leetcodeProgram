package p1;

public class Solution {
    public int game(int[] guess, int[] answer) {
        int len = guess.length;
        int correct = 0;
        for (int i = 0; i < len; i++) {
            if (guess[i] == answer[i]) {
                correct++;
            }
        }
        return correct;
    }

    public static void main(String[] args) {
        int[] g1 = {1,2,3};
        int[] g2 = {1,2,3};
        int t1 = new Solution().game(g1,g2);
        System.out.println(t1);
    }
}

