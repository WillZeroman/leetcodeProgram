/**
 * 广度优先
 * 深度优先
 */
public class Solution {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 深度优先搜索
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left != null && root.right != null && root.val == sum) {
            return true;
        }
        boolean res = false;
        if (root.left != null) {
            res = hasPathSum(root.left, sum - root.val);
        }
        if (!res && root.right != null) {
            res = hasPathSum(root.right, sum - root.val);
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
