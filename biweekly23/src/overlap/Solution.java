package overlap;

public class Solution {
    public boolean checkOverlap(int radius, int x_center, int y_center, int x1, int y1, int x2, int y2) {
        int[] leftTopPoint = {x_center - radius, y_center + radius};
        int[] rightTopPoint = {x_center + radius, y_center + radius};
        int[] leftBottomPoint = {x_center - radius, y_center - radius};
        int[] rightBottomPoint = {x_center + radius, y_center - radius};
        if (x1 <= leftTopPoint[0] && leftTopPoint[0] <= x2 && y1 <= leftTopPoint[1] && leftTopPoint[1] <= y2) {
            return true;
        }
        if (x1 <= rightTopPoint[0] && rightTopPoint[0] <= x2 && y1 <= rightTopPoint[1] && rightTopPoint[1] <= y2) {
            return true;
        }
        if (x1 <= leftBottomPoint[0] && leftBottomPoint[0] <= x2 && y1 <= leftBottomPoint[1]
            && leftBottomPoint[1] <= y2) {
            return true;
        }
        if (x1 <= rightBottomPoint[0] && rightBottomPoint[0] <= x2 && y1 <= rightBottomPoint[1]
            && rightBottomPoint[1] <= y2) {
            return true;
        }
        if (leftBottomPoint[0] <= x1 && x1 <= rightTopPoint[0] && leftBottomPoint[1] <= y1 && y1 <= rightTopPoint[1]) {
            return true;
        }
        if (leftBottomPoint[0] <= x2 && x2 <= rightTopPoint[0] && leftBottomPoint[1] <= y2 && y2 <= rightTopPoint[1]) {
            return true;
        }
        if (leftBottomPoint[0] <= x1 && x1 <= rightTopPoint[0] && leftBottomPoint[1] <= y2 && y2 <= rightTopPoint[1]) {
            return true;
        }
        if (leftBottomPoint[0] <= x2 && x2 <= rightTopPoint[0] && leftBottomPoint[1] <= y1 && y1 <= rightTopPoint[1]) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        //        System.out.println(new Solution().checkOverlap(1,0,0,1,-1,3,1));
        //        System.out.println(new Solution().checkOverlap(1,0,0,-1,0,0,1));
        //        System.out.println(new Solution().checkOverlap(1,1,1,-3,-3,3,3));
        //        System.out.println(new Solution().checkOverlap(1,1,1,1,-3,2,-1));
        System.out.println(new Solution().checkOverlap(1415, 807, -784, -733, 623, -533, 1005));
    }
}
