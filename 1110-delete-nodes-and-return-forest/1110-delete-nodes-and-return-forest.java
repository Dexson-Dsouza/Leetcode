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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> deleted=new HashSet<>();
        for(int n:to_delete){
            deleted.add(n);
        }
        List<TreeNode> forests=new ArrayList<>();
        traverse(root,true,deleted,forests);
        return forests;
    }
    
    boolean traverse(TreeNode root, boolean parentDeleted, Set<Integer> deleted, List<TreeNode> forests){
        if(root==null){
            return false;
        }
        
        boolean isDeleted= deleted.contains(root.val);
        
        if(parentDeleted==true && isDeleted==false){
            forests.add(root);
        }
        
        boolean left=traverse(root.left,isDeleted,deleted,forests);
        boolean right=traverse(root.right,isDeleted,deleted,forests);
        
        if(left==true){
            root.left=null;
        }
        if(right==true){
            root.right=null;
        }
        return isDeleted;
    }
}