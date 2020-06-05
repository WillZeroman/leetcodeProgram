import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class Solution {

    /**
     * fault solution
     *
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }

        String travelLeftString = travelLeft(root.left);
        System.out.println(travelLeftString);
        String travelRightString = travelRight(root.right);
        System.out.println(travelRightString);
        return travelLeftString.equals(travelRightString);
    }

    private String travelLeft(TreeNode node) {
        String res = "";
        if (node == null) {
            return res;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            TreeNode curNode = queue.poll();
            if (curNode.val == Integer.MAX_VALUE) {
                res += "null";
            } else {
                res += curNode.val;
                if (curNode.left == null && curNode.right == null) {
                    continue;
                }
                if (curNode.left != null) {
                    queue.add(curNode.left);
                } else {
                    queue.add(new TreeNode(Integer.MAX_VALUE));
                }

                if (curNode.right != null) {
                    queue.add(curNode.right);
                } else {
                    queue.add(new TreeNode(Integer.MAX_VALUE));
                }
            }
        }
        return res;
    }

    private String travelRight(TreeNode node) {
        String res = "";
        if (node == null) {
            return res;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            TreeNode curNode = queue.poll();
            if (curNode.val == Integer.MAX_VALUE) {
                res += "null";
            } else {
                res += curNode.val;
                if (curNode.left == null && curNode.right == null) {
                    continue;
                }

                if (curNode.right != null) {
                    queue.add(curNode.right);
                } else {
                    queue.add(new TreeNode(Integer.MAX_VALUE));
                }
                if (curNode.left != null) {
                    queue.add(curNode.left);
                } else {
                    queue.add(new TreeNode(Integer.MAX_VALUE));
                }
            }
        }
        return res;
    }

    public boolean isSymmetric_right(TreeNode root) {
        return check(root, root);
    }

    private boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && check(p.left,q.right) && check(p.right,q.left);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(1);
        //root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(1);
        root.right.right = new TreeNode(4);
        root.left.right.left = new TreeNode(2);
        root.right.right.left = new TreeNode(2);
        System.out.println(new Solution().isSymmetric_right(root));

    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
