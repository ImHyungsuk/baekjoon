import java.util.*;
import java.io.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 0;
        Map<String,Integer> map=new HashMap<>();
        ArrayList<String> arr=new ArrayList<>();
        for(int i=0;i<clothes.length;i++){
            if(map.containsKey(clothes[i][1])){
                int cnt=map.get(clothes[i][1]);
                cnt++;
                map.put(clothes[i][1],cnt);
            }else{
                map.put(clothes[i][1],1);
                arr.add(clothes[i][1]);
            }
        }
        int mul=1;
        for(int i=0;i<arr.size();i++){
            String key = arr.get(i);
            mul*=(map.get(key)+1);
        }
        answer=mul-1;
        
        return answer;
    }
}