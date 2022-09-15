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
        return isValid(root,null,null);
    }
     public boolean isValid(TreeNode root, Integer minSoFar, Integer maxSoFar){
         if(root==null){
             return true;
         }
         
         if((minSoFar!=null && root.val <= minSoFar) || (maxSoFar !=null && root.val>= maxSoFar)){
             return false;
         }
         return isValid(root.left,minSoFar,root.val) && isValid(root.right,root.val,maxSoFar);
     }
    
}