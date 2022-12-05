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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null){
            return null;
        }
        if(root.val==key){
            TreeNode nextRoot;
            
            if(root.right==null){
                nextRoot = root.left;
            }else{
                nextRoot = root.right;
                TreeNode temp = nextRoot;
                while(temp.left!=null){
                    temp=temp.left;
                }
                temp.left = root.left;
            }
            return nextRoot;
        }else if(root.val<key){
            root.right = deleteNode(root.right,key);
        }else{
            root.left = deleteNode(root.left,key);
        }
        return root;
    }
}