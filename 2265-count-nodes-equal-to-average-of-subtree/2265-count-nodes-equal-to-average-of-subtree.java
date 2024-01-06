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
    public int averageOfSubtree(TreeNode root) {
        int[] result = findTargetNodes(root);
        return result[2];
    }
    
    public int[] findTargetNodes(TreeNode root){
        if(root==null){
            return new int[]{0,0,0};
        }
        int[] leftResult = findTargetNodes(root.left);
        
        int leftSum = leftResult[0],leftCount = leftResult[1], leftTargetCount = leftResult[2];
        
        int[] rightResult = findTargetNodes(root.right);
        
        int rightSum = rightResult[0],rightCount = rightResult[1], rightTargetCount = rightResult[2];
    
        int totalTargetCount = leftTargetCount+rightTargetCount;
    
        int totalNodeCount = leftCount+rightCount+1;
        
        int subTreeSum = (leftSum+rightSum+root.val);
        
        int subTreeAverage = (subTreeSum)/(leftCount+rightCount+1);
        if(subTreeAverage==root.val){
            totalTargetCount++;
        }
        return new int[]{subTreeSum,totalNodeCount,totalTargetCount};
    }
}