import java.util.*;
class Solution {
    static int[]dx={1,-1,0,0};
    static int[]dy={0,0,1,-1};
    public int solution(int[][] game_board, int[][] table) {
        int answer = 0;
        ArrayList<ArrayList<Dot>>blanks=new ArrayList<>();
        ArrayList<ArrayList<Dot>>pieces=new ArrayList<>();
        
        
        int len=game_board.length;
        int cnt=0;
        boolean[][]board_visited=new boolean[len][len];
        boolean[][]table_visited=new boolean[len][len];
        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                if(!board_visited[i][j]&&game_board[i][j]==0){
                    blanks.add(bfs(j,i,game_board,0,board_visited));
                }
                if(!table_visited[i][j]&&table[i][j]==1){
                    pieces.add(bfs(j,i,table,1,table_visited));
                }
            }
        }
        
        boolean []used=new boolean[pieces.size()];
        for(ArrayList<Dot>board_piece:blanks){
            boolean found=false;
            for(int i=0;i<pieces.size();i++){
                if(used[i]) continue;
                ArrayList<Dot>piece=pieces.get(i);
                for(int r=0;r<4;r++){
                    rotate(piece);
                    if(board_piece.equals(piece)){
                        used[i]=true;
                        answer+=piece.size();
                        found=true;
                        break;
                    }
                }
                if(found)break;
            }
        }
        
        return answer;
    }
    
    static ArrayList<Dot>bfs(int x,int y,int[][]board,int target, boolean[][]visited){
        Queue<Dot>q=new LinkedList<>();
        ArrayList<Dot>pieces=new ArrayList<>();
        q.add(new Dot(x,y));
        visited[y][x]=true;
        int len=board.length;
        while(!q.isEmpty()){
            Dot cur=q.poll();
            pieces.add(cur);
            for(int i=0;i<4;i++){
                int nx=cur.x+dx[i];
                int ny=cur.y+dy[i];
                if(nx<0||ny<0||nx>=len||ny>=len)continue;
                if(!visited[ny][nx]&&board[ny][nx]==target){
                    visited[ny][nx]=true;
                    q.add(new Dot(nx,ny));
                }
            }
        }
        normalize(pieces);
        return pieces;
    }
    
    static void normalize(ArrayList<Dot>arr){
        int minX=arr.get(0).x;
        int minY=arr.get(0).y;
        for(Dot d:arr){
            minX=Math.min(d.x,minX);
            minY=Math.min(d.y,minY);
        }
        for(Dot d:arr){
            d.x-=minX;
            d.y-=minY;
        }
        arr.sort((d1,d2)->{
            if(d1.x==d2.x)return d1.y-d2.y;
            else return d1.x-d2.x;
        });
    }
    
    static void rotate(ArrayList<Dot>arr){
        for(Dot d:arr){
            int tmp=d.x;
            d.x=d.y;
            d.y=-tmp;
        }
        normalize(arr);
    }
}

class Dot{
    int x,y;
    public Dot(int x,int y){
        this.x=x;
        this.y=y;
    }
    
    @Override
    public boolean equals(Object o){
        Dot d=(Dot)o;
        return this.x==d.x&&this.y==d.y;
    }
    
    @Override
    public int hashCode(){
        return Objects.hash(x,y);
    }
}