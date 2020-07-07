/**
 *
 */
public class Solution {

    /**
     *
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest(int[] nums, int target) {
        int[] tempArray = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            tempArray[i] = Math.abs(nums[i] - target);
        }
        int[] resIndex = {0, 1, 2};
        heapify(tempArray,resIndex);
        for (int i = 3; i < nums.length; i++) {
            if (tempArray[i] < tempArray[resIndex[0]]) {
                resIndex[0] = i;
                heapify(tempArray,resIndex);
            }
        }
        int sum = 0;
        for(int index: resIndex){
            sum += nums[index];
        }
        return sum;
    }

    private void heapify(int[] tempArray, int[] resIndex) {
        if (tempArray[resIndex[0]] > tempArray[resIndex[1]]) {
            // swap
            int temp = resIndex[0];
            resIndex[0] = resIndex[1];
            resIndex[1] = temp;
        }
        if (tempArray[resIndex[0]] > tempArray[resIndex[2]]) {
            // swap
            int temp = resIndex[0];
            resIndex[0] = resIndex[2];
            resIndex[2] = temp;
        }
    }

    public static void main(String[] args) {
        int[] nums = {0,2,1,-3};
        System.out.println(new Solution().threeSumClosest(nums, 1));
    }
}
