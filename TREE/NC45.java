import java.util.Arrays;

public class NC45 {

    // Solution 1: 超时

    // public static int[][] threeOrders (TreeNode root) {
    //     // write code here
    //     return new int[][]{Preorder(root), Inorder(root), Postorder(root)};
    // }

    // public static int[] Preorder(TreeNode root){
    //     if (root == null) return new int[]{};
    //     else{
    //         TreeNode left = root.left;
    //         TreeNode right = root.right;
    //         int[] preorderLeft = Preorder(left);
    //         int[] preorderRight = Preorder(right);
    //         int[] preorderRoot = new int[preorderLeft.length + preorderRight.length + 1];
    //         preorderRoot[0] = root.val;
    //         for (int i = 0; i < preorderLeft.length; i++){
    //             preorderRoot[i+1] = preorderLeft[i];
    //         }
    //         for (int i = 0; i < preorderRight.length; i++){
    //             preorderRoot[i+1+preorderLeft.length] = preorderRight[i];
    //         }
    //         return preorderRoot;
    //     }
    // }

    // public static int[] Inorder(TreeNode root){
    //     if (root == null) return new int[]{};
    //     else{
    //         TreeNode left = root.left;
    //         TreeNode right = root.right;
    //         int[] inorderLeft = Inorder(left);
    //         int[] inorderRight = Inorder(right);
    //         int[] inorderRoot = new int[inorderLeft.length + inorderRight.length + 1];
    //         int digit = 0;
    //         for (int i : inorderLeft){
    //             inorderRoot[digit++] = i;
    //         }
    //         inorderRoot[digit++] = root.val;
    //         for (int i : inorderRight){
    //             inorderRoot[digit++] = i;
    //         }
    //         return inorderRoot;
    //     }
    // }

    // public static int[] Postorder(TreeNode root){
    //     if (root == null) return new int[]{};
    //     else{
    //         TreeNode left = root.left;
    //         TreeNode right = root.right;
    //         int[] postorderLeft = Postorder(left);
    //         int[] postorderRight = Postorder(right);
    //         int[] postorderRoot = new int[postorderLeft.length + postorderRight.length + 1];
    //         int digit = 0;
    //         for (int i : postorderLeft){
    //             postorderRoot[digit++] = i;
    //         }
    //         for (int i : postorderRight){
    //             postorderRoot[digit++] = i;
    //         }
    //         postorderRoot[digit++] = root.val;
    //         return postorderRoot;
    //     }
    // }








    // Solution 2: 超时

    private static int preIndex = 0, inIndex = 0, postIndex = 0;
    public static int[][] threeOrders (TreeNode root) {
        // write code here
        int n = count(root);

        int[][] result = new int[3][n];
        orders(root, result);
        return result;
    }

    // Count the nodes
    public static int count(TreeNode root){
        if (root == null) return 0;
        else return count(root.left) + count(root.right) + 1;
    }
    
    public static void orders(TreeNode root, int[][] res){
        if (root == null) return;
        res[0][preIndex++] = root.val;
        orders(root.left, res);
        res[1][inIndex++] = root.val;
        orders(root.right, res);
        res[2][postIndex++] = root.val;
    }


    public static void main(String[] args){
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);

        for (int[] list : threeOrders(tree)){
            System.out.println(Arrays.toString(list));
        }
    }
}
