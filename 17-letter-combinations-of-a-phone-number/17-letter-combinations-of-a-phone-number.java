class Solution {
    public List<String> letterCombinations(String digits) {
        String[] numberPad=new String[]{"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        int index=0;
        List<String> combinationList;
        List<String> prevCombos=new ArrayList<>();
        while(index<digits.length()){
            combinationList=new ArrayList<>();
            int numberIndex = digits.charAt(index)-'2';
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
            prevCombos=combinationList;
            index++;
        }
        return prevCombos;
    }
}