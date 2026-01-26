import java.util.*;
class Solution {
    boolean solution(String s) {
        boolean answer = true;

        Stack<Character> st=new Stack<>();
        for(int idx=0;idx<s.length();idx++){
            if(s.charAt(idx)=='(')
                st.push('(');
            else {
                if(st.isEmpty()){
                    answer=false;
                    return answer;
                }
                st.pop();
            }
        }
        answer=st.isEmpty();

        return answer;
    }
}