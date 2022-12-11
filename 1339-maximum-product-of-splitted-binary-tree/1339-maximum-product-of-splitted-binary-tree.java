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
    public int maxProduct(TreeNode root) {
        int totalSum = findSumTree(root);
        long[] res=new long[1];
        findMaxSum(root,res,totalSum);
        int MOD = (int)(Math.pow(10,9)+7);
        // System.out.println(res[0]);
        return (int)(res[0]%MOD);
    }
    
    int findSumTree(TreeNode root){
        if(root==null){
            return 0;
        }
        
        int leftSum = findSumTree(root.left);
        int rightSum = findSumTree(root.right);
        return root.val + leftSum + rightSum;
    }
    
    int findMaxSum(TreeNode n, long[] res, int totalSum){
        if(n==null){
            return 0;
        }
        int leftSum = findMaxSum(n.left,res,totalSum);
        int rightSum = findMaxSum(n.right,res,totalSum);
        int total  =leftSum + rightSum + n.val;
        long totalProduct = (long)(total)*(totalSum - total);
        res[0] = Math.max(res[0],totalProduct);
        return total;
    }
    
}