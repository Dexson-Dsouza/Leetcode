/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    List<Integer> flattendList;
    int index;
    public NestedIterator(List<NestedInteger> nestedList) {
        flattendList = new ArrayList<>();
        flatten(nestedList,flattendList);
        index = 0;
    }

    public void flatten(List<NestedInteger> nestedList, List<Integer> flattendList){
        for(NestedInteger n:nestedList){
            if(n.isInteger()){
                flattendList.add(n.getInteger());
            }else{
                flatten(n.getList(),flattendList);
            }
        }
    }
    
    @Override
    public Integer next() {
        return flattendList.get(index++);
    }

    @Override
    public boolean hasNext() {
        return index<flattendList.size();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */