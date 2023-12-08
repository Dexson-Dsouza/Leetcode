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
    public String tree2str(TreeNode root) {
        if(root==null){
            return "";
        }
        
        String left = "";
        boolean hasChild = root.right!=null || root.left!=null;
        if(hasChild){
            left+='(';
            left+=tree2str(root.left);
            left+=')';
        }
        String right = "";
        if(root.right!=null){
            right+='(';
            right+=tree2str(root.right);
            right+=')';
        }
        return root.val+left+right;
        
    }
}