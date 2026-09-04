import java.util.*;

class Solution {
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        boolean[]visited=new boolean[tickets.length];
        Arrays.sort(tickets,(String[]a,String[]b)->{
            if(a[0].equals(b[0]))
                return a[1].compareTo(b[1]);
            return a[0].compareTo(b[0]);
        });
        ArrayList<String>path=new ArrayList<>();
        path.add("ICN");
        answer=new String[tickets.length+1];
        path=dfs("ICN",path,tickets,visited,0);
        for(int i=0;i<=tickets.length;i++){
            answer[i]=path.get(i);
        }
        return answer;
    }
    
    ArrayList<String>dfs(String cur,ArrayList<String>ret, String[][]tickets,boolean[]visited,int cnt){
        if(ret.size()==tickets.length+1)
            return ret;
        for(int i=0;i<tickets.length;i++){
            if(!visited[i]&&tickets[i][0].equals(cur)){
                visited[i]=true;
                ret.add(tickets[i][1]);
                ret=dfs(tickets[i][1],ret,tickets,visited,cnt+1);
                if(ret.size()==tickets.length+1)return ret;
                visited[i]=false;
            }
        }
        ret.remove(ret.size()-1);
        return ret;
    }
}