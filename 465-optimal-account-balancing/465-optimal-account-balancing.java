class Solution {
    public int minTransfers(int[][] transactions) {
Map<Integer,Integer> personDebtMap = new HashMap<>();
for(int[] 	transaction:transactions){
	int from=transaction[0];
	int to=transaction[1];
	int amount=transaction[2];
	personDebtMap.put(from,personDebtMap.getOrDefault(from,0)+amount);
	personDebtMap.put(to,personDebtMap.getOrDefault(to,0)-amount);
}

int totalPeople=personDebtMap.size();
int[] debts=new int[totalPeople];
int debtPersonIndex=0;
for(int person:personDebtMap.keySet()){
	debts[debtPersonIndex] = personDebtMap.get(person);
    debtPersonIndex++;
}
	
	Integer[] minimumTransactionRequired=new Integer[totalPeople];
	return findMinimunTransactions(debts,0,minimumTransactionRequired);
}

int findMinimunTransactions(int[] debts, int curPerson, Integer[] minimumTransactionRequired){
 
    if(curPerson==debts.length){
		return 0;
}
    // System.out.println(curPerson+" "+ debts[curPerson] );
if(debts[curPerson]==0){
	return findMinimunTransactions(debts,curPerson+1,minimumTransactionRequired);
}
// if(minimumTransactionRequired[curPerson]!=null){
// 	return minimumTransactionRequired[curPerson];
// }

int transactions=Integer.MAX_VALUE;

for(int nextPerson=curPerson+1;nextPerson<debts.length;nextPerson++){
	// if(debts[curPerson]*debts[nextPerson]<0){
		int t= debts[curPerson];
		debts[nextPerson]+=t;
		transactions=Math.min(transactions,
1+findMinimunTransactions(debts,curPerson+1,minimumTransactionRequired));
		debts[nextPerson]-=t;
// }
}
minimumTransactionRequired[curPerson] = transactions;
   
return transactions;
}

}