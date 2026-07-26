import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {};
        TreeMap<Integer,Integer> map=new TreeMap<>();
        
        for(String ops:operations){
            String[]parts=ops.split(" ");
            String cmd=parts[0];
            int num=Integer.parseInt(parts[1]);
            
            if(cmd.equals("I")){
                map.put(num,map.getOrDefault(num,0)+1);
            }else if(cmd.equals("D")&&!map.isEmpty()){
                int target=num==1?map.lastKey():map.firstKey();
                
                if(map.put(target,map.get(target)-1)==1) map.remove(target);
            }
        }
        if(map.isEmpty()) answer=new int[]{0,0};
        else answer=new int[]{map.lastKey(),map.firstKey()};
        return answer;
    }
}