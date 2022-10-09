class Bitset {
    int[] bits;
    int ones;
    boolean flip;
    
    public Bitset(int size) {
        bits=new int[size];
        ones=0;
        flip=false;
    }
    
    public void fix(int idx) {
        if(flip){
            if(bits[idx]==1){
                bits[idx]=0;
                ones++;
            }
        }else{
           if(bits[idx]==0){
                bits[idx]=1;
                ones++;
            } 
        }
        
    }
    
    public void unfix(int idx) {
        if(flip){
            if(bits[idx]==0){
                bits[idx]=1;
                ones--;
            }
        }else{
           if(bits[idx]==1){
                bits[idx]=0;
                ones--;
            } 
        }
    }
    
    public void flip() {
        flip = !flip;
        ones=bits.length-ones;
    }
    
    public boolean all() {
        return ones==bits.length;
    }
    
    public boolean one() {
        return ones>=1;
    }
    
    public int count() {
        return ones;
    }
    
    public String toString() {
        StringBuilder bitStr=new StringBuilder();
        for(int i=0;i<bits.length;i++){
            if(flip){
                bits[i]=1-bits[i];
            }
            bitStr.append(bits[i]);
        }
        flip=false;
        return bitStr.toString();
    }
}

/**
 * Your Bitset object will be instantiated and called as such:
 * Bitset obj = new Bitset(size);
 * obj.fix(idx);
 * obj.unfix(idx);
 * obj.flip();
 * boolean param_4 = obj.all();
 * boolean param_5 = obj.one();
 * int param_6 = obj.count();
 * String param_7 = obj.toString();
 */