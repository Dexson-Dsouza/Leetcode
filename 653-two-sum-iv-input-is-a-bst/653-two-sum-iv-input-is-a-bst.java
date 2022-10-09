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
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> nums=new HashSet<>();
        
        return find(root,k,nums);
    }
    
    boolean find(TreeNode root, int k, Set<Integer> nums){
        if(root==null){
            return false;
        }
        if(nums.contains(k-root.val)){
            return true;
        }
        nums.add(root.val);
        return find(root.left,k,nums) || find(root.right,k,nums);
    }
}