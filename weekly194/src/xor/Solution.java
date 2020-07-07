package xor;

public class Solution {
    public int xorOperation(int n, int start) {
        int sum = start;
        for(int i=1;i<n;i++){
            int tmp = start + 2*i;
            sum ^= tmp;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().xorOperation(5,0));
        System.out.println(new Solution().xorOperation(4,3));
        System.out.println(new Solution().xorOperation(1,7));
        System.out.println(new Solution().xorOperation(10,5));
    }
}
