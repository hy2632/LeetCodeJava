import java.util.*;

/*
 * public class TreeNode {
 *   int val = 0;
 *   TreeNode left = null;
 *   TreeNode right = null;
 * }
 */

public class NowCoder_LevelOrder {
    /**
     * 
     * @param root TreeNode类
     * @return int整型ArrayList<ArrayList<>>
     */
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        // write code here
        ArrayList<Integer> width = new ArrayList<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        if (root.left == null && root.right == null) {
            width.add(root.val);
            result.add(width);
            return result;
        }
        int depth = treeDepth(root);
        for (int i = 0; i < depth; i++) {
            result.add(ithlevel(root, i));
        }
        return result;
    }

    public static int treeDepth(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(treeDepth(root.left), treeDepth(root.right)) + 1;
    }

    public static ArrayList<Integer> ithlevel(TreeNode root, int i) {
        ArrayList<Integer> width = new ArrayList<>();
        if (root == null)
            return width;
        if (i == 0) {
            width.add(root.val);
            return width;
        } else {
            ArrayList<Integer> leftwidth = ithlevel(root.left, i - 1);
            ArrayList<Integer> rightwidth = ithlevel(root.right, i - 1);
            for (int val : rightwidth) {
                leftwidth.add(val);
            }
            return leftwidth;
        }
    }

}