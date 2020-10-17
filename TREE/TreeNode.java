public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int x){
        this.val = x;
        this.left = null;
        this.right = null;
    }

    public static void main(String[] args){
        TreeNode tr = new TreeNode(5);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        tr.left = left;
        tr.right = right;
        System.out.println(tr.left.val);
    }
}
