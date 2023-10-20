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
    Stack<NestedInteger> flattendStack;
    int index;
    public NestedIterator(List<NestedInteger> nestedList) {
        flattendStack = new Stack<>();
        addToStack(nestedList,flattendStack);
        index = 0;
    }

    public void addToStack(List<NestedInteger> nestedList, Stack<NestedInteger> flattendStack){
        for(int i=nestedList.size()-1;i>=0;i--){
            flattendStack.push(nestedList.get(i));
        }
    }
    
    @Override
    public Integer next() {
        return flattendStack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        while(flattendStack.size()>0 && !flattendStack.peek().isInteger()){
            List<NestedInteger> nestedList = flattendStack.pop().getList();
            addToStack(nestedList,flattendStack);
        }
        return flattendStack.size()>0;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */