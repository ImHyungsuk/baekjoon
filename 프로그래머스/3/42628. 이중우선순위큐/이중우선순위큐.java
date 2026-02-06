import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        TreeMap<Integer,Integer>map=new TreeMap<>();
        for(String str:operations){
            StringTokenizer st=new StringTokenizer(str," ");
            String op=st.nextToken();
            int num=Integer.parseInt(st.nextToken());
            if(op.equals("I")){
                map.put(num,map.getOrDefault(num,0)+1);
            }else{
                if(map.isEmpty())continue;
                int key=(num==1)?map.lastKey():map.firstKey();
                if(map.put(key,map.get(key)-1)==1){
                    map.remove(key);
                }
            }
        }
        if(map.isEmpty()){
            answer[0]=0;
            answer[1]=0;
        }else{
            answer[0]=map.lastKey();
            answer[1]=map.firstKey();
        }
        
        return answer;
    }
}