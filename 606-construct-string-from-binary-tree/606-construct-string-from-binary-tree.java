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
        StringBuilder treeString=new StringBuilder();
        buildTreeString(root,treeString);
        return treeString.toString();
    }
    
    void buildTreeString(TreeNode root, StringBuilder treeString){
        if(root==null){
            return;
        }
        treeString.append(root.val);
        if(root.left!=null || root.right!=null){
            treeString.append("(");
            buildTreeString(root.left,treeString);
            treeString.append(")");
        }
        
        if(root.right!=null){
            treeString.append("(");
            buildTreeString(root.right,treeString);
            treeString.append(")");
        }
    }
}