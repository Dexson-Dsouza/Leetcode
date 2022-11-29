class BrowserHistory {
    List<String> historyList;
    int index;
    int size;
    public BrowserHistory(String homepage) {
        historyList=new ArrayList<>();
        index = 0;
        size = 1;
        historyList.add(homepage);
    }
    
    public void visit(String url) {
        index++;
        size = index+1;
        if(index>=historyList.size()){
            historyList.add(url);
        }else{
            historyList.set(index,url);
        }
    }
    
    public String back(int steps) {
        index = Math.max(0,index-steps);
        // System.out.println(historyList+" "+index);
        return historyList.get(index);
    }
    
    public String forward(int steps) {
        index = Math.min(size-1,index+steps);
        // System.out.println(historyList+" "+index);
        return historyList.get(index);
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */