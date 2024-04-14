class TextEditor {
    Deque<Character> left = new ArrayDeque<>();
    Deque<Character> right = new ArrayDeque<>();
    
    public TextEditor() {}
    
    public void addText(String text) {
        for(char c: text.toCharArray()){
            left.addLast(c);
        }
    }
    
    public int deleteText(int k) {
        int count = 0;
        while(!left.isEmpty() && k > 0){
            left.pollLast();
            count++;
            k--;
        }
        return count;
    }
    
    public String cursorLeft(int k) {
        while(!left.isEmpty() && k > 0){
            right.addFirst(left.pollLast());
            k--;
        }
        // System.out.println(left+" "+right);
        return lastTen();
    }
    
    public String cursorRight(int k) {
        while(!right.isEmpty() && k > 0){
            left.addLast(right.pollFirst());
            k--;
        }
        // System.out.println(left+" "+right);
        return lastTen();
    }
    
    String lastTen(){
        StringBuilder sb = new StringBuilder();
        int count = 10;
        
        while(!left.isEmpty() && count > 0){
            sb.append(left.pollLast());
            count--;
        }
        String last = sb.reverse().toString();
        addText(last);
        return last;
    }
}
/**
 * Your TextEditor object will be instantiated and called as such:
 * TextEditor obj = new TextEditor();
 * obj.addText(text);
 * int param_2 = obj.deleteText(k);
 * String param_3 = obj.cursorLeft(k);
 * String param_4 = obj.cursorRight(k);
 */