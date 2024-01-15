class Solution {
    public int oddEvenJumps(int[] arr) {
        int input_len = arr.length;
        boolean[][] can_reach = new boolean[input_len][2];
        
        for(int i=0;i<input_len;i++){
            can_reach[i][0]=can_reach[i][1]=false;
        }
        
        int last_index=input_len-1;
        can_reach[last_index][0]=can_reach[last_index][1]=true;
        
        TreeMap<Integer,Integer> value_index_map=new TreeMap<>();
        int good_indices_count = 0;
        for(int i=last_index;i>=0;i--){
            int value = arr[i];
            int even_jump_index;
            Integer even_jump_value = value_index_map.ceilingKey(value);
            if(even_jump_value!=null){
                even_jump_index=value_index_map.get(even_jump_value);
                can_reach[i][0] = can_reach[even_jump_index][1];
            }
            int odd_jump_index;
            Integer odd_jump_value = value_index_map.floorKey(value);
            if(odd_jump_value!=null){
                odd_jump_index=value_index_map.get(odd_jump_value);
                can_reach[i][1] = can_reach[odd_jump_index][0];
            }
            // System.out.println(i+ " "+even_jump_index+" "+odd_jump_index);
            if(can_reach[i][0]==true){
                good_indices_count++;
            }
            
            value_index_map.put(value,i);
        }
        
        return good_indices_count;
    }
}