import java.util.*;
class Solution {
    static int MAX=102;
    static int[]dx={1,-1,0,0};
    static int[]dy={0,0,1,-1};
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        int [][]board=new int[MAX][MAX];
        for(int[]r:rectangle){
            int x1=r[0]*2;
            int y1=r[1]*2;
            int x2=r[2]*2;
            int y2=r[3]*2;
            for(int x=x1;x<=x2;x++){
                for(int y=y1;y<=y2;y++){
                    board[y][x]=1;
                }
            }
        }
        for(int[]r:rectangle){
            int x1=r[0]*2;
            int y1=r[1]*2;
            int x2=r[2]*2;
            int y2=r[3]*2;
            for(int x=x1+1;x<x2;x++){
                for(int y=y1+1;y<y2;y++){
                    board[y][x]=0;
                }
            }
        }
        answer=bfs(characterX*2,characterY*2,itemX*2,itemY*2,board);
        return answer;
    }
    
    static int bfs(int cX,int cY,int iX,int iY,int[][]board){
        int ret=0;
        boolean[][]visited=new boolean[MAX][MAX];
        Queue<int[]>q=new LinkedList<>();
        q.add(new int[]{cX,cY,0});
        visited[cY][cX]=true;
        while(!q.isEmpty()){
            int[]cur=q.poll();
            if(cur[0]==iX&&cur[1]==iY)
                return cur[2]/2;
            for(int i=0;i<4;i++){
                int nX=cur[0]+dx[i];
                int nY=cur[1]+dy[i];
                
                if(nX<0||nX>=102||nY<0||nY>=102||visited[nY][nX])
                    continue;
                
                if(board[nY][nX]==1){
                    q.add(new int[]{nX,nY,cur[2]+1});
                    visited[nY][nX]=true;
                }
            }
        }
        return 0;
    }
}