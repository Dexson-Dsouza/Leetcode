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
    public int maxAncestorDiff(TreeNode root) {
        if(root==null){
            return 0;
        }
        
        return maxDiff(root,root.val,root.val);
    }
    
    public int maxDiff(TreeNode root, int minSoFar, int maxSoFar){
        if(root==null){
            return 0;
        }
        
        int curDiff = Math.max(Math.abs(minSoFar-root.val), Math.abs(maxSoFar-root.val));
        minSoFar = Math.min(minSoFar,root.val);
        maxSoFar = Math.max(maxSoFar,root.val);
        int leftDiff = maxDiff(root.left,minSoFar,maxSoFar);
        int rightDiff = maxDiff(root.right,minSoFar,maxSoFar);
        return Math.max(curDiff,Math.max(leftDiff,rightDiff));
    }
}