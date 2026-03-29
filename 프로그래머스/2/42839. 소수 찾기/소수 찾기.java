import java.util.*;
class Solution {
    static Set<Integer>set=new HashSet<>();
    public int solution(String numbers) {
        int answer = 0;
        boolean[]isNotPrime=new boolean[10000000];
        isNotPrime[0]=true;
        isNotPrime[1]=true;
        for(int i=2;i<10000000;i++){
            if(isNotPrime[i])continue;
            for (int j=2;i*j<10000000;j++){
                isNotPrime[i*j]=true;
            }
        }
        int len=numbers.length();
        char[]arr=numbers.toCharArray();
        boolean[]visited=new boolean[len];
        dfs(arr,visited,"",isNotPrime);
        answer=set.size();
        return answer;
    }
    
    static void dfs(char[]arr,boolean[]visited,String current,boolean[]isNotPrime){
        int len=arr.length;
        if(!current.equals("")){
            int num=Integer.parseInt(current);
            if(!isNotPrime[num])
                set.add(num);
        }
        for(int i=0;i<len;i++){
            if(!visited[i]){
                visited[i]=true;
                dfs(arr,visited,current+arr[i],isNotPrime);
                visited[i]=false;
            }
        }
    }
}