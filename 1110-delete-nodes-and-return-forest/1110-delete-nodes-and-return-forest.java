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
        Set<TreeNode> forest=new HashSet<>();
        forest.add(root);
        Map<TreeNode,TreeNode> nodeParentMap=new HashMap<>();
        Map<Integer,TreeNode> valueNodeMap=new HashMap<>();
        traverse(root,null,nodeParentMap,valueNodeMap);
        
        for(int val:to_delete){
            TreeNode node = valueNodeMap.get(val);
            // remove from forest
            forest.remove(node);
            
            // disconnect from tree
            
            TreeNode parent = nodeParentMap.get(node);
            if(parent!=null && parent.left==node){
                parent.left=null;
            }else if(parent!=null && parent.right==node){
                parent.right=null;
            }
            // add children
            if(node.left!=null){
                forest.add(node.left);
            }
            if(node.right!=null){
                forest.add(node.right);
            }
            
                
        }
        return new ArrayList<>(forest);
    }
    
    void traverse(TreeNode root, TreeNode par, Map<TreeNode,TreeNode> nodeParentMap,
                 Map<Integer,TreeNode> valueNodeMap){
        if(root==null){
            return;
        }
        valueNodeMap.put(root.val,root);
        nodeParentMap.put(root,par);
        traverse(root.left,root,nodeParentMap,valueNodeMap);
        traverse(root.right,root,nodeParentMap,valueNodeMap);
    }
}