/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    TreeNode lca = null;
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        findLCA(root,p,q);
        return lca;
    }
    
    public boolean findLCA(TreeNode root, TreeNode p, TreeNode q){
        if(root==null){
            return false;
        }
        
        boolean leftSearch = findLCA(root.left,p,q);
        boolean rightSearch = findLCA(root.right,p,q);
        if(lca!=null){
            return true;
        }
        if(leftSearch && rightSearch){
            lca = root;
            return true;
        }
        
        if((root==p) || (root==q)){
            if(leftSearch || rightSearch){
                lca = root;
            }
            
            return true;
        }
        return leftSearch || rightSearch;
    }
}