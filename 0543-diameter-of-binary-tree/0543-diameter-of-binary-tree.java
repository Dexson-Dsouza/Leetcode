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
    public int diameterOfBinaryTree(TreeNode root) {
        int[] diameterPair = findDiameter(root);
        return diameterPair[0];
    }
    
    public int[] findDiameter(TreeNode root){
        if(root==null){
            return new int[]{0,0};
        }
        
        int[] leftHeightDiameterPair = findDiameter(root.left);
        int[] rightHeightDiameterPair = findDiameter(root.right);
        
        int maxHeight = 1 + Math.max(leftHeightDiameterPair[1],rightHeightDiameterPair[1]);
        int currentdiameter = leftHeightDiameterPair[1] + rightHeightDiameterPair[1];
        int maxDiameterTree = Math.max(leftHeightDiameterPair[0],rightHeightDiameterPair[0]);
        maxDiameterTree = Math.max(maxDiameterTree,currentdiameter);
        return new int[]{maxDiameterTree,maxHeight};
        
    }
}