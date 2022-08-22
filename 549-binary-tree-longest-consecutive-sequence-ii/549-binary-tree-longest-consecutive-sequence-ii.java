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
    public int longestConsecutive(TreeNode root) {
        int[] longestRoute=findLongest(root,new int[3]);
        return longestRoute[0];
    }
    
    public int[] findLongest(TreeNode root, int[] routes){
        if(root==null){
            return routes;
        }
        
        int[] leftRoutes=findLongest(root.left,routes);
        
        int[] rightRoutes=findLongest(root.right,routes);
        
        int increaseLength=1;
        int decreasingLength=1;
        
        if(root.left!=null && root.left.val+1==root.val){
            increaseLength= Math.max(increaseLength,1 + leftRoutes[1]);
        }
        
        if(root.left!=null && root.left.val-1==root.val){
            decreasingLength= Math.max(decreasingLength,1 + leftRoutes[2]);
        }
        
        if(root.right!=null && root.right.val+1==root.val){
            increaseLength= Math.max(increaseLength,1 + rightRoutes[1]);
        }
        
        if(root.right!=null && root.right.val-1==root.val){
            decreasingLength= Math.max(decreasingLength,1 + rightRoutes[2]);
        }
        
        int maxLen=Math.max(increaseLength,decreasingLength);
        
        if(root.left!=null && root.right!=null){
            if(root.left.val+1 == root.val && root.right.val-1 ==root.val){
                maxLen=Math.max(maxLen,leftRoutes[1]+rightRoutes[2]+1);
            }
            
            if(root.left.val-1 == root.val && root.right.val+1 ==root.val){
                maxLen=Math.max(maxLen,leftRoutes[2]+rightRoutes[1]+1);
            }
        }
        return new int[]{Math.max(maxLen,Math.max(leftRoutes[0],rightRoutes[0])),increaseLength,decreasingLength};
    }
}