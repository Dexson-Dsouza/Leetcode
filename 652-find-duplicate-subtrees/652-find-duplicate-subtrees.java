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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> duplicates=new ArrayList<>();
        Set<String> keys=new HashSet<>();
        Set<String> addedKeys=new HashSet<>();
        serializeAndFindDuplicates(root,keys,addedKeys,duplicates);
        return duplicates;
    }
    
    String serializeAndFindDuplicates(TreeNode root, Set<String> keys, Set<String> addedKeys, List<TreeNode> duplicates){
        if(root==null){
            return "#";   
        }
        
        String leftKey=serializeAndFindDuplicates(root.left,keys,addedKeys,duplicates);
        String rightKey=serializeAndFindDuplicates(root.right,keys,addedKeys,duplicates);
        
        String rootKey=root.val + ","+leftKey+ ","+rightKey;
        
        if(keys.contains(rootKey)){
            if(addedKeys.contains(rootKey)==false){
                duplicates.add(root);
                addedKeys.add(rootKey);
            }
        }else{
            keys.add(rootKey);
        }
        return rootKey;
    }
}