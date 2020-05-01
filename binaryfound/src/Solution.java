public class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length -1;
        while(low <=high)
        {
            int mid = low + ((high-low) >> 1);
            if(nums[low] < nums[mid]) {
                if(nums[low]<=target && target <=nums[mid]){
                    //search by binary
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] data = {4,5,6,7,0,1,2};
        int res = new Solution().search(data,0);
        System.out.println(res);
    }
}
