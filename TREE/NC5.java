/*
 * public class TreeNode {
 *   int val = 0;
 *   TreeNode left = null;
 *   TreeNode right = null;
 * }
 */

public class NC5 {
    /**
     * 
     * @param root TreeNode类 
     * @return int整型
     */
    public static int sumNumbers (TreeNode root) {
        // write code here
        if (root == null) return 0;
        return preOrder(root, 0);
    }

    public static int preOrder(TreeNode root, int sum){
        if (root == null) return 0;
        sum = sum * 10 + root.val;
        if (root.left == null && root.right == null) return sum;
        else{
            return preOrder(root.left, sum) + preOrder(root.right, sum);
        }
    }


    public static void main(String[] args){
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        a.left = b;
        a.right = c;
        System.out.println(sumNumbers(a));
    }
}
