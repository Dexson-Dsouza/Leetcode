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
        return validateBST(root.left,Long.MIN_VALUE,root.val) 
            && validateBST(root.right,root.val,Long.MAX_VALUE);
    }
    
    public boolean validateBST(TreeNode root, long lowerBound, long upperBound){
        if(root==null){
            return true;
        }
        
        if(root.val<=lowerBound || root.val>=upperBound){
            return false;
        }
        
        return validateBST(root.left,lowerBound,root.val)
            && validateBST(root.right,root.val,upperBound);
    }
}