class MaxStack {
    private Stack<int[]> stack;
    private PriorityQueue<int[]> heap;
    private Set<Integer> removed;
    private int id; // ID of each number

    public MaxStack() {
        id=0;
        stack = new Stack<>();
        heap = new PriorityQueue<>((a, b) -> b[0] - a[0] == 0 ? b[1] - a[1] : b[0] - a[0]);
        removed = new HashSet<>();
    }

    public void push(int x) {
        stack.add(new int[] { x, id });
        heap.add(new int[] { x, id });
        id++;
    }

    public int pop() {
        removeStackPoppedElements();
        int[] top = stack.pop();
        removed.add(top[1]);
        return top[0];
    }

    public int top() {
        removeStackPoppedElements();
        return stack.peek()[0];
    }

    public int peekMax() {
        
        removeMaxPoppedElements();
        return heap.peek()[0];
    }
    
    void removeMaxPoppedElements(){
         while (removed.contains(heap.peek()[1])) {
            heap.poll();
        }
    }
    
    void removeStackPoppedElements(){
         while (removed.contains(stack.peek()[1])) {
            stack.pop();
        }
    }

    public int popMax() {
        removeMaxPoppedElements();
        int[] top = heap.poll();
        removed.add(top[1]);
        return top[0];
    }
}