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
    public int distributeCoins(TreeNode root) {
        int[] result=new int[1];
        findMovesRequired(root,result);
        return result[0];
    }
    
    int findMovesRequired(TreeNode root, int[] result){
        if(root==null){
            return 0;
        }
        int leftDeficit=findMovesRequired(root.left,result);
        int rightDeficit=findMovesRequired(root.right,result);
        
        result[0] += Math.abs(leftDeficit)+Math.abs(rightDeficit);
        return (root.val+leftDeficit+rightDeficit)-1;
    }
}