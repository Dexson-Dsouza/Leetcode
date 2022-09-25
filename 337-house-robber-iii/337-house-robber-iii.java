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
        int[] maxMoney=robHouse(root);
        return Math.max(maxMoney[0],maxMoney[1]);
    }
    
    public int[] robHouse(TreeNode root){
        if(root==null){
            return new int[]{0,0};
        }
        
        int[] leftMoney = robHouse(root.left);
        int[] rightMoney = robHouse(root.right);
        
        int robChildren = leftMoney[0]+rightMoney[0];
        int robWithoutChildren = leftMoney[1]+rightMoney[1];
        
        int curRob=Math.max(robWithoutChildren+root.val,robChildren);
        
        return new int[]{curRob,Math.max(robWithoutChildren,robChildren)};
    }
}