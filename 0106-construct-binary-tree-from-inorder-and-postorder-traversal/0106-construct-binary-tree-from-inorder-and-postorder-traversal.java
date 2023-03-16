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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(inorder,0,inorder.length-1,postorder,0,postorder.length-1);
    }
    
    public TreeNode helper(int[] inorder, int is, int ie, int[] postorder, int ps, int pe){
        if(ps>pe){
            return null;
        }
        
        TreeNode root = new TreeNode(postorder[pe]);
        if(ps==pe){
            return root;
        }
        
        int rootIndexInorder = -1;
        for(int i=is;i<=ie;i++){
            if(postorder[pe]==inorder[i]){
                rootIndexInorder = i;
                break;
            }
        }
        
        int rightSubtreeNodeCount = ie - rootIndexInorder ;
        int leftSubtreeCount = rootIndexInorder - is;
        root.left = helper(inorder,is,rootIndexInorder-1,postorder,ps,ps+leftSubtreeCount-1);
        root.right = helper(inorder,rootIndexInorder+1,ie,postorder,ps+leftSubtreeCount,pe-1);
        
        return root;
    }
}