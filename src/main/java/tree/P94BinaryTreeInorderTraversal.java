package tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class P94BinaryTreeInorderTraversal {

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();

        while(root != null || !stack.isEmpty()) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            ans.add(root.val);
            root = root.right;
        }
        return ans;
    }

    static List<Integer> inorderTraversalValue = new ArrayList<>();

    public static void inorderTraversalUsingRecursion(TreeNode root) {
        if(root == null) {
            return;
        }
        inorderTraversalUsingRecursion(root.left);
        inorderTraversalValue.add(root.val);
        inorderTraversalUsingRecursion(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(8);
        root.right.right.right.right = new TreeNode(9);
        System.out.println(inorderTraversal(root));
        inorderTraversalUsingRecursion(root);
        System.out.println(inorderTraversalValue);
    }
}
