import java.util.*;
class Solution {
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        Arrays.sort(tickets,(String[]s1,String[]s2)->s1[1].compareTo(s2[1]));
        Set<String>set=new HashSet<>();
        for(int i=0;i<tickets.length;i++){
            set.add(tickets[i][0]);
            set.add(tickets[i][1]);
        }
        boolean[]visited=new boolean[tickets.length];
        answer=new String[tickets.length+1];
        answer[0]="ICN";
        answer=dfs(tickets,answer,visited,0);
        
        return answer;
    }
    
    static String[]dfs(String[][]tickets,String[]path,boolean[]visited,int idx){
        String cur=path[idx];
        if(idx==tickets.length)return path;
        for(int i=0;i<tickets.length;i++){
            if(visited[i])continue;
            if(tickets[i][0].equals(cur)){
                path[idx+1]=tickets[i][1];
                visited[i]=true;
                
                String[]ret=dfs(tickets,path,visited,idx+1);
                if(ret!=null)return ret;
                
                visited[i]=false;
            }
        }
        return null;
    }
}