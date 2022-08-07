class Solution {
    public List<String> letterCombinations(String digits) {
        String[] numberPad=new String[]{"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        return generateCombos(0,digits,numberPad,new ArrayList<>());
    }
    
    public List<String> generateCombos(int i,String digits, String[] numberPad, List<String> prevCombos){
        if(i==digits.length()){
            return prevCombos;
        }
        List<String> combinationList=new ArrayList<>();
        int numberIndex = digits.charAt(i)-'2';
        if(prevCombos.size()==0){
            for(char c:numberPad[numberIndex].toCharArray()){
                combinationList.add(String.valueOf(c));
            }
        }else{
            for(String s:prevCombos){
                for(char c:numberPad[numberIndex].toCharArray()){
                    combinationList.add(s+c);
                }
            }
        }
        return generateCombos(i+1,digits,numberPad,combinationList);
    }
}