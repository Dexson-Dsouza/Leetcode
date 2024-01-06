class RLEIterator {
    int[] encoding;
    int encoderIndex;
    public RLEIterator(int[] encoding) {
        this.encoding = encoding;
        this.encoderIndex=0;
    }
    
    public int next(int n) {
        int term = -1;
        
        while(n>0 && encoderIndex<encoding.length){
            int count = encoding[encoderIndex];
            int element = encoding[encoderIndex+1];
            if(count>=n){
                term = element;
                count -=n;
                n=0;
                encoding[encoderIndex] = count;
            }else{
                n -= count;
                encoderIndex+=2;
            }
        }
        return term;
    }
}

/**
 * Your RLEIterator object will be instantiated and called as such:
 * RLEIterator obj = new RLEIterator(encoding);
 * int param_1 = obj.next(n);
 */