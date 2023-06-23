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
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        if(root1==null || root2==null){
            return false;
        }
        
        int sum = root1.val + root2.val;
        
        if(sum==target){
            return true;
        }
        
        if(sum<target){
            return twoSumBSTs(root1.right,root2,target) || twoSumBSTs(root1,root2.right,target);
        }else{
            return twoSumBSTs(root1.left,root2,target) || twoSumBSTs(root1,root2.left,target);
        }
        
        
    }
}