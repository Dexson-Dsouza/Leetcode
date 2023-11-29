class Solution {
    public  static List<Integer> diffWaysToCompute(String expression) {
        Map<String,List<Integer>> computedResults = new HashMap<>();
        return compute(expression,0,expression.length()-1,computedResults);
    }
    
    public static List<Integer> compute(String e, int l, int r, Map<String,List<Integer>> computedResults){
        List<Integer> results = new ArrayList<>();
        if(l>r){
          return results;
        }
        String key = l+"_"+r;
        if(computedResults.containsKey(key)){
          return computedResults.get(key);
        }
        for(int i=l;i<=r;i++){
          char ch = e.charAt(i);
          if(!Character.isDigit(ch)){
            List<Integer> left= compute(e,l,i-1,computedResults);
            List<Integer> right= compute(e,i+1,r,computedResults);
            for(int leftR:left){
              for(int rightR:right){
                int result;
                if(ch =='+'){
                  result = leftR+rightR;
                }else if(ch =='-'){
                  result = leftR-rightR;
                }else if(ch =='*'){
                  result = leftR*rightR;
                }else {
                  result = leftR/rightR;
                }
                results.add(result);
              }
            }
          }
        }

        if(results.size()==0){
          results.add(Integer.parseInt(e.substring(l, r+1)));
        }

        computedResults.put(key,results);
        return results;
    }
}