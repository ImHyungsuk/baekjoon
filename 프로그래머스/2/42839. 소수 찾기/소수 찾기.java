import java.util.*;
class Solution {
    Set<Integer>set=new HashSet<>();
    public int solution(String numbers) {
        int answer = 0;
        boolean[]isNotPrime=new boolean[10000000];
        int l=(int)Math.sqrt(10000000);
        boolean[]visited=new boolean[numbers.length()];
        isNotPrime[0]=true;
        isNotPrime[1]=true;
        for(int i=2;i<l;i++){
            // if(isNotPrime[i])continue;
            for(int j=2;i*j<10000000;j++){
                isNotPrime[i*j]=true;
            }
        }
        dfs("",visited,numbers,isNotPrime);
        answer=set.size();
        return answer;
    }
    
    void dfs(String current,boolean[]visited, String numbers,boolean[]isNotPrime){
        int len=numbers.length();
        if(!current.equals("")){
            int num=Integer.parseInt(current);
            if(!isNotPrime[num]) set.add(num);
        }
        for(int i=0;i<len;i++){
            if(!visited[i]){
                visited[i]=true;
                dfs(current+numbers.substring(i,i+1),visited,numbers,isNotPrime);
                visited[i]=false;
            }
        }
    }
}