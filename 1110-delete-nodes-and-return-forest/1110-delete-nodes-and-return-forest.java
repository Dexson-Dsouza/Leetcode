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
        Set<Integer> toDeleteSet=new HashSet<>();
        for(int n:to_delete){
            toDeleteSet.add(n);
        }
        List<TreeNode> forest=new ArrayList<>();
        
        traverse(root,toDeleteSet,forest,false);
        return forest;
    }
    
    TreeNode traverse(TreeNode root, Set<Integer> toDeleteSet, List<TreeNode> forest, boolean hasParent){
        if(root==null){
            return null;
        }
        if(toDeleteSet.contains(root.val)){
            root.left=traverse(root.left,toDeleteSet,forest,false);
            root.right=traverse(root.right,toDeleteSet,forest,false);  
            return null;
        }else{
            if(!hasParent){
                forest.add(root);
            }
            root.left=traverse(root.left,toDeleteSet,forest,true);
            root.right=traverse(root.right,toDeleteSet,forest,true);
            return root;
        }
    }
}