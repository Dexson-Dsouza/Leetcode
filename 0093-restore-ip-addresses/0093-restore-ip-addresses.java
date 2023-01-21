class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<Integer> nums = new ArrayList<>();
        List<String> res = new ArrayList<>();
        generate(s,0,nums,res);
        return res;
    }
    
    public void generate(String s, int index, List<Integer> nums, List<String> res){
        if(index==s.length()){
            // System.out.println(nums);
            if(nums.size()==4){
                StringBuilder sb = new StringBuilder();
                for(int n:nums){
                    sb.append(n);
                    sb.append(".");
                }
                sb.deleteCharAt(sb.length()-1);
                res.add(sb.toString());
            }
            return;
        }
        int cur = 0;
        int i = index;
        while(i<s.length()){
            int digit = s.charAt(i) - '0';
            
            if((i>index && cur==0)){
                break;
            }
            cur = cur*10 + digit;
            if(cur>255){
                break;
            }
            nums.add(cur);
            generate(s,i+1,nums,res);
            nums.remove(nums.size()-1);
            i++;
        }
    }
}