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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth==1){
            TreeNode newRoot=new TreeNode(val);
            newRoot.left=root;
            return newRoot;
        }
        return addRow(root,val,depth-1);
    }
    
    TreeNode addRow(TreeNode root, int val, int depth){
        if(root==null){
            return null;
        }
        if(depth==1){
            TreeNode newLeftTree=new TreeNode(val);
            newLeftTree.left=root.left;
            TreeNode newRightTree=new TreeNode(val);
            newRightTree.right=root.right;
            root.left=newLeftTree;
            root.right=newRightTree;
            return root;
        }
        root.left = addRow(root.left,val,depth-1);
        root.right = addRow(root.right,val,depth-1);
        return root;
    }
}