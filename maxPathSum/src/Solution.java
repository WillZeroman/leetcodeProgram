public class Solution {
    public int maxPathSum(TreeNode root) {
        int[] res = maxPath(root);
        return res[1];
    }

    public int[] maxPath(TreeNode node) {
        if (node.left == null && node.right == null) {
            return new int[]{node.val, node.val};
        }

        int[] leftSum = {Integer.MIN_VALUE, Integer.MIN_VALUE};
        if (node.left != null) {
            leftSum = maxPath(node.left);
        }

        int[] rightSum = {Integer.MIN_VALUE, Integer.MIN_VALUE};
        if (node.right != null) {
            rightSum = maxPath(node.right);
        }

        int leftEdgeMax = leftSum[0];
        int rightEdgeMax = rightSum[0];

        int edgeMax = node.val + Math.max(leftEdgeMax, rightEdgeMax);
        int max1 = Math.max(node.val + rightEdgeMax,Math.max(node.val,node.val + leftEdgeMax));
        int max2 = Math.max(node.val + leftEdgeMax + rightEdgeMax, Math.max(leftSum[1], rightSum[1]));
        return new int[]{edgeMax, Math.max(max1,max2)};
    }


    public static void main(String[] args) {

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
