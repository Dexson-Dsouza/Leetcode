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
    public int maxPathSum(TreeNode root) {
        int[] maxSum = new int[1];
        maxSum[0]=Integer.MIN_VALUE;
        findMaxPathSum(root,maxSum);
        return maxSum[0];
    }
    
    public int findMaxPathSum(TreeNode root, int[] maxSum){
        if(root==null){
            return 0;
        }
        int leftSum =  findMaxPathSum(root.left,maxSum);
        int rightSum =  findMaxPathSum(root.right,maxSum);
        int maxBranchSum = Math.max(leftSum,rightSum);
        maxSum[0] = Math.max(Math.max(root.val,maxSum[0]),root.val + leftSum + rightSum);
        // System.out.println(root.val + " "+maxSum[0]);
        return Math.max(Math.max(0,root.val),root.val + maxBranchSum);
    }
}