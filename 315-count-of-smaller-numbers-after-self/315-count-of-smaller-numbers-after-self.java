class indexElementPair{
    int index;
    int num;
    indexElementPair(int index, int num){
        this.index=index;
        this.num=num;
    }
}

class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int inputSize=nums.length;
        
        indexElementPair[] inputList=new indexElementPair[inputSize];
        
        for(int index=0;index<inputSize;index++){
            inputList[index]= new indexElementPair(index,nums[index]);
        }
        
        int[] countOfSmaller=new int[inputSize];
        
        mergeSort(inputList,0,inputSize-1,countOfSmaller);
        
        List<Integer> result=new ArrayList<>();
        for(int n:countOfSmaller){
            result.add(n);
        }
        return result;
    }
    
    void mergeSort(indexElementPair[] inputList, int s, int e, int[] countOfSmaller){
        if(s>=e){
            return;
        }
        int mid=s+(e-s)/2;
        mergeSort(inputList,s,mid,countOfSmaller);
        mergeSort(inputList,mid+1,e,countOfSmaller);
        
        List<indexElementPair> mergeList=new ArrayList<>();
        int left=s;
        int right=mid+1;
        int countOfSmallerElementsInRight=0;
        while(left<=mid && right<=e){
            if(inputList[left].num<=inputList[right].num){
                mergeList.add(inputList[left]);
                countOfSmaller[inputList[left].index]+=countOfSmallerElementsInRight;
                left++;
            }else{
                mergeList.add(inputList[right]);
                countOfSmallerElementsInRight++;
                right++;
            }
        }
        
        while(left<=mid){
            countOfSmaller[inputList[left].index]+=countOfSmallerElementsInRight;
            mergeList.add(inputList[left]);
            left++;
        }
        while(right<=e){
            mergeList.add(inputList[right]);
            right++;
        }
        
        int index=s;
        for(indexElementPair ele:mergeList){
            inputList[index]=ele;
            index++;
        }
    }
}