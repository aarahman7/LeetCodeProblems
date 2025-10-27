import java.util.ArrayDeque;
import java.util.Deque;

public class P100SameTree {

    public static void main(String[] args) {
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(3);
        p.left.left = new TreeNode(4);
        p.left.right = new TreeNode(5);
        p.right.left = new TreeNode(6);
        p.right.right = new TreeNode(7);
        p.right.right.right = new TreeNode(8);
        p.right.right.right.right = new TreeNode(9);

        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(2);
        q.right = new TreeNode(3);
        q.left.left = new TreeNode(4);
        q.left.right = new TreeNode(5);
        q.right.left = new TreeNode(6);
        q.right.right = new TreeNode(7);
        q.right.right.right = new TreeNode(8);
        q.right.right.right.right = new TreeNode(9);

        System.out.println(isSameTreeRecursion(p, q));
    }

    public static boolean isSameTreeRecursion(TreeNode p, TreeNode q) {
            if(p == null && q == null) {
                return true;
            }
            if(p == null || q == null) {
                return false;
            }
            if(p.val != q.val) {
                return false;
            }
            boolean status = true;
            status &= isSameTreeRecursion(p.left, q.left);

            status &= isSameTreeRecursion(p.right, q.right);

            return status;
    }

    public static boolean isSameTreeIterative(TreeNode p, TreeNode q) {
        // Use a queue to perform BFS traversal on both trees simultaneously
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(p);
        queue.offer(q);

        while (!queue.isEmpty()) {
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();

            // Both nodes are null - continue to next pair
            if (node1 == null && node2 == null) {
                continue;
            }

            // One is null and the other isn't - trees are different
            if (node1 == null || node2 == null) {
                return false;
            }

            // Values are different - trees are different
            if (node1.val != node2.val) {
                return false;
            }

            // Add left children to queue
            queue.offer(node1.left);
            queue.offer(node2.left);

            // Add right children to queue
            queue.offer(node1.right);
            queue.offer(node2.right);
        }

        return true;
    }
}
