import java.util.*;

class Solution {
    static List<ArrayList<Point>>boardPieces=new ArrayList<>();
    static List<ArrayList<Point>>tablePieces=new ArrayList<>();
    static int[]dx={-1,1,0,0};
    static int[]dy={0,0,-1,1};
    public int solution(int[][] game_board, int[][] table) {
        int answer = 0;
        int n=table.length;
        
        boolean[][]boardVisited=new boolean[n][n];
        boolean[][]tableVisited=new boolean[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(game_board[i][j]==0&&!boardVisited[i][j])
                    boardPieces.add(bfs(game_board,j,i,0,boardVisited));
                if(table[i][j]==1&&!tableVisited[i][j])
                    tablePieces.add(bfs(table,j,i,1,tableVisited));
            }
        }
        boolean[]used=new boolean[tablePieces.size()];
        
        for(ArrayList<Point>boardPiece:boardPieces){
            boolean found=false;
            for(int i=0;i<tablePieces.size();i++){
                ArrayList<Point>tablePiece=tablePieces.get(i);
                if(used[i]) continue;
                // if(boardPiece.size()!=tablePiece.size())continue;
                for(int r=0;r<4;r++){
                    tablePiece=rotate(tablePiece);
                    if(boardPiece.equals(tablePiece)){
                        used[i]=true;
                        answer+=tablePiece.size();
                        found=true;
                        break;
                    }
                }
                if(found)break;
            }
        }
        
        return answer;
    }
    
    private ArrayList<Point>bfs(int[][]grid,int x,int y,int target,boolean[][]visited){
        Queue<Point>q=new ArrayDeque<>();
        ArrayList<Point> piece=new ArrayList<>();
        int n=grid.length;
        q.add(new Point(x,y));
        visited[y][x]=true;
        while(!q.isEmpty()){
            Point cur=q.poll();
            piece.add(cur);
            for(int i=0;i<4;i++){
                int nx=cur.x+dx[i];
                int ny=cur.y+dy[i];
                if(nx<0||ny<0||nx>=n||ny>=n||visited[ny][nx]||grid[ny][nx]!=target)continue;
                
                q.add(new Point(nx,ny));
                visited[ny][nx]=true;
            }
        }
        normalize(piece);
        return piece;
    }
    
    private ArrayList<Point> rotate(ArrayList<Point>arr){
        ArrayList<Point> rotated=new ArrayList<>();
        for(Point p:arr){
            rotated.add(new Point(-p.y,p.x));
        }
        normalize(rotated);
        return rotated;
    }
    
    private void normalize(ArrayList<Point>arr){
        int minX=arr.get(0).x;
        int minY=arr.get(0).y;
        for(Point p:arr){
            minX=Math.min(minX,p.x);
            minY=Math.min(minY,p.y);
        }
        for(Point p:arr){
            p.x-=minX;
            p.y-=minY;
        }
        arr.sort((p1,p2)->{
            if(p1.x==p2.x)return p1.y-p2.y;
            else return p1.x-p2.x;
        });
    }
    
}

class Point{
    int x,y;
    public Point(int x, int y){
        this.x=x;
        this.y=y;
    }
    
    @Override
    public boolean equals(Object o){
        Point p=(Point)o;
        return this.x==p.x && this.y==p.y;
    }
    
    @Override
    public int hashCode(){
        return Objects.hash(x,y);
    }
}