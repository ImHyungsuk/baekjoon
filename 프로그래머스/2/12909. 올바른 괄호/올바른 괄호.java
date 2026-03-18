import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        char[]arr=s.toCharArray();
        Stack<Character>st=new Stack<>();
        for(char c:arr){
            if(c=='(')st.add(c);
            else {
                if(st.isEmpty()){
                    answer=false;
                    break;
                }
                st.pop();
            }
        }
        if(!st.isEmpty())answer=false;

        return answer;
    }
}