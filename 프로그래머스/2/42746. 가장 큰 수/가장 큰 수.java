import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[]nums=Arrays.stream(numbers)
            .mapToObj(String::valueOf)
            .sorted((a,b)->(b+a).compareTo(a+b))
            .toArray(String[]::new);
        if(nums[0].equals("0"))return "0";
        for(String num:nums){
            answer+=num;
        }
        
        return answer;
    }
}