/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        return validateBST(root,Long.MAX_VALUE,Long.MIN_VALUE);
    }
    
    boolean validateBST(TreeNode root, long maxLimit, long minLimit){
        if(root==null){
            return true;
        }
        if(root.val>=maxLimit || root.val<=minLimit){
            return false;
        }
        return validateBST(root.left,root.val,minLimit) && validateBST(root.right,maxLimit,root.val);
    }
}