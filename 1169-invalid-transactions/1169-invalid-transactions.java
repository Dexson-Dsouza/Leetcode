class Solution {
    
    public static class transactionDetails{
        String transactionStr;
        String name;
        int time;
        int amount;
        String place;
        transactionDetails(String transactionStr,String name, int time, int amount, String place){
            this.transactionStr=transactionStr;
            this.name=name;
            this.time=time;
            this.amount=amount;
            this.place=place;
        }
    }
    public List<String> invalidTransactions(String[] transactions) {
        List<transactionDetails> transactionList=new ArrayList<>();
        int index=0;
        
        for(String transaction:transactions){
            String[] transactionDetailArr=transaction.split(",");
            String name=transactionDetailArr[0];
            int time=Integer.parseInt(transactionDetailArr[1]);
            int amount=Integer.parseInt(transactionDetailArr[2]);
            String place=transactionDetailArr[3];
            transactionList.add(new transactionDetails(transaction+"*"+index,name,time,amount,place));
            index++;
        }
        // Collections.sort(transactionList,(a,b)->a.time-b.time);
        
        Map<String,List<transactionDetails>> nameTransactionMap=new HashMap<>();
        
        for(transactionDetails td:transactionList){
            String name = td.name;
            
            if(nameTransactionMap.containsKey(name)==false){
                nameTransactionMap.put(name,new ArrayList<>());
            }
            nameTransactionMap.get(name).add(td);
        }
        
        List<String> invalidTransactionList=new ArrayList<>(); 
        
        for(String name: nameTransactionMap.keySet()){
            List<transactionDetails> transactionDetailList=nameTransactionMap.get(name);
            Set<String> invalidTransactionSet=new HashSet<>();
            
            for(int i=0;i<transactionDetailList.size();i++){
                transactionDetails currentTransaction = transactionDetailList.get(i);
                if(currentTransaction.amount>1000){
                    invalidTransactionSet.add(currentTransaction.transactionStr);
                }
                String currentPlace=currentTransaction.place;
                int currentTime=currentTransaction.time; 
                for(int j=i+1;j<transactionDetailList.size();j++){
                    int nextTime = transactionDetailList.get(j).time;
                    String nextPlace =  transactionDetailList.get(j).place;
                    if(currentPlace.equals(nextPlace)==false && Math.abs(nextTime-currentTime)<=60){
                        invalidTransactionSet.add(currentTransaction.transactionStr);
                        invalidTransactionSet.add(transactionDetailList.get(j).transactionStr);
                    }
                    
                }
            }
            
            for(String s:invalidTransactionSet){
                invalidTransactionList.add(s.substring(0,s.indexOf("*")));
            }
            
        }
        return invalidTransactionList;
    }
}