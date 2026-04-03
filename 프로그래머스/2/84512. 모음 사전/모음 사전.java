import java.util.*;
class Solution {
    static char[]arr=new char[]{'A','E','I','O','U'};
    static Map<Character,Integer>map=Map.of(
        'A',1,
        'E',2,
        'I',3,
        'O',4,
        'U',5
    );
    public int solution(String word) {
        int answer = 0;
        int len=word.length();
        for(int i=0;i<len;i++){
            int idx=map.get(word.charAt(i));
            int cnt=1;
            for(int j=i;j<4;j++){
                cnt=cnt*5+1;
            }
            answer+=cnt*(idx-1)+1;
        }
        
        return answer;
    }
}