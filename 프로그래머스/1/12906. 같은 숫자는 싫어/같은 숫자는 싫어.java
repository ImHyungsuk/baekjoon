import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        Stack<Integer> st=new Stack<>();
        st.add(arr[0]);
        for(int i=1;i<arr.length;i++){
            if(arr[i]==st.peek()) continue;
            st.add(arr[i]);
        }
        answer=new int[st.size()];
        int idx=st.size()-1;
        while(!st.isEmpty()){
            answer[idx--]=st.pop();
        }

        return answer;
    }
}