
class Solution {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> duplicates=new ArrayList<>();
        Set<String> keys=new HashSet<>();
        Set<String> addedKeys=new HashSet<>();
        serializeAndFindDuplicates(root,keys,addedKeys,duplicates);
        return duplicates;
    }
    
    String serializeAndFindDuplicates(TreeNode root, Set<String> keys, Set<String> duplicateKeys, List<TreeNode> duplicates){
        if(root==null){
            return "#";   
        }
        
        String leftKey=serializeAndFindDuplicates(root.left,keys,duplicateKeys,duplicates);
        String rightKey=serializeAndFindDuplicates(root.right,keys,duplicateKeys,duplicates);
        
        String rootKey=root.val + ","+leftKey+ ","+rightKey;
        
        if(keys.contains(rootKey)){
            if(duplicateKeys.contains(rootKey)==false){
                duplicates.add(root);
                duplicateKeys.add(rootKey);
            }
        }else{
            keys.add(rootKey);
        }
        return rootKey;
    }
}