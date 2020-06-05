public class Solution {
    public double new21Game(int N, int K, int W) {
        int s = 0;
        double p = new21Game(N, K, W, s);
        return p;
    }

    private double new21Game(int n, int k, int w, int s) {
        double p = 1.0 / w;
        double sum = 1.0;
        for (int i = 1; i <= w; i++) {
            if (s + i < n && s < k) {
                double psi = new21Game(n, k, w, s + i);
                sum += p * psi;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().new21Game(10, 1, 10));
        System.out.println(new Solution().new21Game(6, 1, 10));
        System.out.println(new Solution().new21Game(21, 17, 10));
    }
}
