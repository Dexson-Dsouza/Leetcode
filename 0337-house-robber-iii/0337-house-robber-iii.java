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
        int[] skip_take_pair = findMaxAmount(root);
        
        return Math.max(skip_take_pair[0],skip_take_pair[1]);
    }
    
    int[] findMaxAmount(TreeNode root){
        if(root==null){
            return new int[]{0,0};
        }
        
        int[] left_pair = findMaxAmount(root.left);
        int[] right_pair = findMaxAmount(root.right);
    
        int take_root_amount =  root.val + left_pair[1] + right_pair[1];
        int skip_root_amount =  left_pair[0] + right_pair[0];
        
        return new int[]{Math.max(take_root_amount,skip_root_amount),skip_root_amount};
    }
}