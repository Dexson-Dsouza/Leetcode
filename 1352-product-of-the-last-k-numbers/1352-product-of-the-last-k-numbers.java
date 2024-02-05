class ProductOfNumbers {
    List<Integer> prodList;
    public ProductOfNumbers() {
        prodList=new ArrayList<>();
        prodList.add(1);
    }
    
    public void add(int num) {
        if(num!=0){
            int prev=prev=prodList.get(prodList.size()-1);
            prodList.add(num*prev);
            // 2 3 5
            // 2 6 30
        }else{
            prodList=new ArrayList<>();
            prodList.add(1);
        }
    }
    
    public int getProduct(int k) {
        if(k>prodList.size()-1){
            return 0;
        }
        return prodList.get(prodList.size()-1)/prodList.get(prodList.size()-k-1);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */