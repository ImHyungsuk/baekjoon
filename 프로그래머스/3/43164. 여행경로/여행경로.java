import java.util.*;

class Solution {
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        boolean[]used=new boolean[tickets.length];
        String[]path=new String[tickets.length+1];
        Arrays.sort(tickets, (String[]s1,String[]s2)->{
            if(s1[0].equals(s2[0])) return s1[1].compareTo(s2[1]);
            return s1[0].compareTo(s2[0]);
        });
        path[0]="ICN";
        answer = dfs(1,path,tickets,used);
        return answer;
    }
    String[] dfs(int n, String[]path,String[][]tickets,boolean[]used){
        if(n==path.length){
            // System.out.println("n = "+n+" path[n-1] = "+path[n-1]);
            return path;
        }
        for(int i=0;i<tickets.length;i++){
            if(!used[i]&&tickets[i][0].equals(path[n-1])){
                used[i]=true;
                path[n]=tickets[i][1];
                dfs(n+1,path,tickets,used);
                if(path[path.length-1]!=null) {
                    // System.out.println("if not null: path[n-1] = "+path[n-1]);
                    break;
                }
                used[i]=false;
            }
        }
        return path;
    }
}