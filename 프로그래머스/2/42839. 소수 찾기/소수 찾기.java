import java.util.*;

class Solution {
    static Set<Integer>set=new HashSet<>();
    static boolean[]visited;
    public int solution(String numbers) {
        int answer = 0;
        visited=new boolean[numbers.length()];
        dfs("",numbers);
        answer=set.size();
        return answer;
    }
    
    static void dfs(String current,String numbers){
        if(!current.equals("")){
            int num=Integer.parseInt(current);
            if(isPrime(num)){
                // System.out.println(num);
                set.add(num);
            }
        }
        int len=numbers.length();
        for(int i=0;i<len;i++){
            if(!visited[i]){
                visited[i]=true;
                dfs(current+numbers.charAt(i),numbers);
                visited[i]=false;
            }
        }
    }
    
    static boolean isPrime(int num){
        if(num<2)return false;
        for(int i=2;i*i<=num;i++){
            if(num%i==0) return false;
        }
        return true;
    }
}