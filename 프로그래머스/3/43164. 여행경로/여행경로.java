import java.util.*;
class Solution {
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        Arrays.sort(tickets,(String[]a,String[]b)->{
            if(a[0].equals(b[0])) return a[1].compareTo(b[1]);
            else return a[0].compareTo(b[0]);
        });
        boolean[]used=new boolean[tickets.length];
        // StringBuilder sb=new StringBuilder();
        // for(int i=0;i<tickets.length;i++){
        //     sb.append(tickets[i][0]).append(" ").append(tickets[i][1]).append("\n");
        // }
        // System.out.println(sb);
        answer=new String[tickets.length+1];
        answer[0]="ICN";
        dfs("ICN",answer,tickets,used,1);
        return answer;
    }
    
    boolean dfs(String cur,String[]path,String[][]tickets,boolean[]used,int idx){
        if(idx==tickets.length+1)return true;
        for(int i=0;i<tickets.length;i++){
            if(!tickets[i][0].equals(cur)||used[i])continue;
            used[i]=true;
            path[idx]=tickets[i][1];
            if(dfs(tickets[i][1],path,tickets,used,idx+1)) return true;
            used[i]=false;
        }
        return false;
    }
}