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
    public int rob(TreeNode root) {
        int[] robSkipPair = steal(root);
        return robSkipPair[0];
    }
    
    int[] steal(TreeNode root){
        if(root==null){
            return new int[]{0,0};
        }
        
        int[] leftPair = steal(root.left);
        int[] rightPair = steal(root.right);
        
        int stealChildrenAmount = leftPair[0]+rightPair[0];
        int skipChildrenAmount = leftPair[1]+rightPair[1];
        int currentStealAmount = root.val + skipChildrenAmount;
        
        int maxSteal = Math.max(currentStealAmount,stealChildrenAmount);
        
        return new int[]{maxSteal,stealChildrenAmount};
        
    }
}