class Vector2D {
    Queue<Integer> q;
    public Vector2D(int[][] vec) {
        q=new LinkedList<>();
        for(int row[]:vec){
            for(int n:row){
                    q.add(n);    
            }
        }
    }
    
    public int next() {
        return q.poll();
    }
    
    public boolean hasNext() {
        return q.size()>0;
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D obj = new Vector2D(vec);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */