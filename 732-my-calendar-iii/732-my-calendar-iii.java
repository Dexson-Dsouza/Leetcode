class MyCalendarThree {
    TreeMap<Integer,Integer> timeMap;
    public MyCalendarThree() {
        timeMap=new TreeMap<>();
    }
    
    public int book(int start, int end) {
        timeMap.put(start,timeMap.getOrDefault(start,0)+1);
        timeMap.put(end,timeMap.getOrDefault(end,0)-1);
        int max=0;
        int ongoing=0;
        
        for(int time:timeMap.keySet()){
            ongoing += timeMap.get(time);
            max=Math.max(ongoing,max);
        }
        return max;
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(start,end);
 */