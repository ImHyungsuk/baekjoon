import java.util.*;
class Solution {
    static ArrayList<String>arr=new ArrayList<>();
    static boolean[]visited;
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        Arrays.sort(tickets,(t1,t2)->{
            if(t1[0].equals(t2[0])) return t1[1].compareTo(t2[1]);
            else return t1[0].compareTo(t2[0]);
        });
        visited=new boolean[tickets.length];
        dfs("ICN","ICN",tickets,0);
        answer=arr.get(0).split(" ");
        return answer;
    }
    
    static void dfs(String current,String path,String[][]tickets,int count){
        if(count==tickets.length){
            arr.add(path);
            return;
        }
        if(!arr.isEmpty())return;
        for(int i=0;i<tickets.length;i++){
            if(visited[i]) continue;
            if(tickets[i][0].equals(current)){
                visited[i]=true;
                dfs(tickets[i][1],path+" "+tickets[i][1],tickets,count+1);
                visited[i]=false;
            }
        }
    }
}