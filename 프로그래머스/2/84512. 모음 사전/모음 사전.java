import java.util.*;

class Solution {
    static int[] charToNum=new int['Z'];
    public int solution(String word) {
        int answer = 0;
        int len=word.length();
        charToNum['A']=0;
        charToNum['E']=1;
        charToNum['I']=2;
        charToNum['O']=3;
        charToNum['U']=4;
        // AEEEE: 1+(1+1*5^(5-2))+1*5^(5-3)+1*5^(5-4)+1*5^(5-5)+1
        // AAAAE: 1+1+1+1+2
        // AAAE: 1+1+1+1+1*(1+5)
        // I: 1+2*(1+5(1+5(1+5(1+5))))=1+2*781=1563
        // EIO: 1*(1+5(1+5(1+5(1+5))))+1+2*(1+5(1+5(1+5)))+1+3*(1+5(1+5))+1=781+1+312+1+93+1=782+313+94=1095+94=1189
        
        answer=count(word,0,len);
        return answer;
    }
    static int count(String word,int idx,int len){
        if(idx==len) return 0;
        int ret=1;
        int a=charToNum[word.charAt(idx)];
        // System.out.println(word.charAt(idx)+": "+a);
        for(int i=idx+1;i<5;i++){
            ret=ret*5+1;
        }
        ret=ret*a+1;
        ret+=count(word,idx+1,len);
        return ret;
    }
}