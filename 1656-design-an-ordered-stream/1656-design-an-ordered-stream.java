class OrderedStream {
    String[] values;
    int currentIndex=0;
    public OrderedStream(int n) {
        values=new String[n];
        // Arrays.fill(values,null);
    }
    
    public List<String> insert(int idKey, String value) {
        List<String> vals=new ArrayList<>();
        values[idKey-1]=value;
        
        while(currentIndex<values.length && values[currentIndex]!=null){
            vals.add(values[currentIndex]);
            currentIndex++;
        }
        
        return vals;
    }
}

/**
 * Your OrderedStream object will be instantiated and called as such:
 * OrderedStream obj = new OrderedStream(n);
 * List<String> param_1 = obj.insert(idKey,value);
 */