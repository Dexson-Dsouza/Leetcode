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
    public void flatten(TreeNode root) {
        root=flattened(root);
    }
    
    TreeNode flattened(TreeNode root){
        if(root==null){
            return null;
        }
        
        if(root.left!=null){
            TreeNode leftSubtree=root.left;
            root.left=null;
            TreeNode rightSubtree=root.right;
            if(rightSubtree==null){
                root.right=leftSubtree;
            }else{
                TreeNode temp=leftSubtree;
                while(temp.right!=null){
                    temp=temp.right;
                }
                temp.right=rightSubtree;
                root.right=leftSubtree;
            }
        }
        root.right=flattened(root.right);
        return root;
    }
}