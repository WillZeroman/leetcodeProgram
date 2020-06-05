import java.util.ArrayList;
import java.util.List;

/**
 * 根据 前序遍历 和 中序遍历 构造二叉树
 *
 * 1. 递归方法
 */
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }

        List<Integer> preorderList = new ArrayList<>(preorder.length);
        for (int v : preorder) {
            preorderList.add(v);
        }
        List<Integer> inorderList = new ArrayList<>(inorder.length);
        for (int v : inorder) {
            inorderList.add(v);
        }

        TreeNode treeNode = buildTree(preorderList, inorderList);
        return treeNode;
    }

    private TreeNode buildTree(List<Integer> preorderList, List<Integer> inorderList) {
        if (preorderList.size() == 1) {
            return new TreeNode(preorderList.get(0));
        }
        TreeNode treeNode = new TreeNode(preorderList.get(0));
        int i = 0;
        for (; i < inorderList.size(); i++) {
            if (inorderList.get(i) == treeNode.val) {
                break;
            }
        }
        if (i > 0) {
            List<Integer> leftPreOrderList = preorderList.subList(1, 1 + i);
            List<Integer> leftInorderList = inorderList.subList(0, i);
            treeNode.left = buildTree(leftPreOrderList, leftInorderList);
        }

        if (i < inorderList.size() - 1) {
            List<Integer> rightPreOrderList = preorderList.subList(1 + i, preorderList.size());
            List<Integer> rightInOrderList = inorderList.subList(i + 1, inorderList.size());
            treeNode.right = buildTree(rightPreOrderList, rightInOrderList);
        }
        return treeNode;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        @Override public String toString() {
            return "TreeNode{" + "val=" + val + ", left=" + left + ", right=" + right + '}';
        }
    }

    public static void main(String[] args) {
        int[] preorder = {3,9,20,15};
        int[] inorder = {9,3,15,20};
        TreeNode node = new Solution().buildTree(preorder, inorder);
        System.out.println(node);
    }
}



