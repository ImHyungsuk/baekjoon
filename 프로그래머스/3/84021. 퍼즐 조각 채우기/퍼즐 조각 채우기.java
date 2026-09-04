import java.util.*;

class Solution {
    static int []dx={-1,1,0,0};
    static int []dy={0,0,-1,1};
    public int solution(int[][] game_board, int[][] table) {
        int answer = 0;
        int n=game_board.length;
        boolean[][]board_visited=new boolean[n][n];
        boolean[][]table_visited=new boolean[n][n];
        ArrayList<ArrayList<Dot>>blanks=new ArrayList<>();
        ArrayList<ArrayList<Dot>>pieces=new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(game_board[i][j]==0 && !board_visited[i][j]){
                    blanks.add(bfs(j,i,game_board,board_visited,0));
                }
                if(table[i][j]==1 && !table_visited[i][j])
                    pieces.add(bfs(j,i,table,table_visited,1));
            }
        }
        int l=pieces.size();
        boolean[]used=new boolean[l];
        for(ArrayList<Dot>blank:blanks){
            boolean flag=false;
            for(int i=0;i<l;i++){
                if(flag)break;
                if(used[i]) continue;
                ArrayList<Dot>piece=pieces.get(i);
                if(blank.size()!=piece.size()) continue;
                for(int j=0;j<4;j++){
                    rotate(piece);
                    
                    int cnt=0;
                    for(int k=0;k<piece.size();k++){
                        Dot b=blank.get(k);
                        Dot p=piece.get(k);
                        if(b.x!=p.x||b.y!=p.y)break;
                        cnt++;
                    }
                    
                    if(cnt==piece.size()){
                        // System.out.printf("%dth piece amount=%d piece=%d, blank=%d\n",i,cnt,piece.size(),blank.size());
                        used[i]=true;
                        answer+=cnt;
                        flag=true;
                        break;
                    }
                }
            }
        }
        
        return answer;
    }
    
    ArrayList<Dot> bfs(int x,int y,int[][]map,boolean[][]visited,int target){
        int n=map.length;
        ArrayList<Dot>list=new ArrayList<>();
        
        Queue<Dot>q=new LinkedList<>();
        q.add(new Dot(x,y));
        visited[y][x]=true;
        
        while(!q.isEmpty()){
            Dot cur=q.poll();
            list.add(cur);
            for(int i=0;i<4;i++){
                int nX=cur.x+dx[i];
                int nY=cur.y+dy[i];
                if(nX<0||nY<0||nX>=n||nY>=n||visited[nY][nX]||map[nY][nX]!=target)continue;
                visited[nY][nX]=true;
                q.add(new Dot(nX,nY));
            }
        }
        normalize(list);
        return list;
    }
    
    void normalize(ArrayList<Dot>list){
        list.sort((a,b)->{
            if(a.x==b.x)return a.y-b.y;
            return a.x-b.x;
        });
        Dot d=list.get(0);
        int x=d.x,y=d.y;
        for(Dot dot:list){
            dot.x-=x;
            dot.y-=y;
        }
    }
    
    void rotate(ArrayList<Dot>list){
        for(Dot d:list){
            int tmp=d.y;
            d.y=d.x*(-1);
            d.x=tmp;
        }
        normalize(list);
    }
}
class Dot{
    int x,y;
    Dot(int x,int y){
        this.x=x;
        this.y=y;
    }
    
    @Override
    public boolean equals(Object o){
        Dot d=(Dot)o;
        return d.x==this.x && d.y==this.y;
    }
}