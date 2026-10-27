import java.util.*;
class Solution {
    public String solution(String number, int k) {
        String answer = "";
        Queue<Integer>q=new LinkedList<>();
        int idx=0,len=number.length();
        StringBuilder sb=new StringBuilder();
        while(idx<len){
            char cur=number.charAt(idx);
            // System.out.println("cur = "+cur+" "+k+" "+q.isEmpty()+" "+(q.isEmpty()?-1:q.peek()));
            
            while(k>0&&sb.length()>0&&sb.charAt(sb.length()-1)<cur){
                k--;
                sb.deleteCharAt(sb.length()-1);
            }
            sb.append(cur);
            idx++;
        }
        sb.setLength(sb.length()-k);
        answer=sb.toString();
        return answer;
    }
}