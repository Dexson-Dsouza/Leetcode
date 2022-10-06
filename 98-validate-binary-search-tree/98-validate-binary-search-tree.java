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
    // DO INORDER
    long minSoFar=Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        return validate(root);
    }
    
    boolean validate(TreeNode root){
        if(root==null){
            return true;
        }
        if(validate(root.left)==false){
            return false;
        }
        // System.out.println(root.val+" "+minSoFar);
        if(root.val<=minSoFar){
            return false;
        }
        minSoFar=root.val;
        if(validate(root.right)==false){
            return false;
        }
        return true;
    }
}