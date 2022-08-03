class MyCalendar {
    TreeMap<Integer,Integer> bookings;
    public MyCalendar() {
        bookings=new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        Integer left=bookings.lowerKey(end);
        if(left!=null && bookings.get(left)>start){
            return false;
        }
        bookings.put(start,end);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */