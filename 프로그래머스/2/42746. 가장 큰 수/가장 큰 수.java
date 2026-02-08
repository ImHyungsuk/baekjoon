import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        int len=numbers.length;
        String[]arr=new String[len];
        for(int i=0;i<len;i++){
            arr[i]=Integer.toString(numbers[i]);
        }
        Arrays.sort(arr,(a,b)-> (a+b).compareTo(b+a));
        if(arr[len-1].equals("0"))return "0";
        for(int i=len-1;i>=0;i--){
            answer+=arr[i];
        }
        return answer;
    }
}