import java.util.*;
class Solution {
    static int [][]board=new int[102][102];
    static boolean [][]visited=new boolean[102][102];
    static int[]dx={-1,1,0,0};
    static int[]dy={0,0,-1,1};
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        for(int []r:rectangle){
            int x1=r[0]*2;
            int y1=r[1]*2;
            int x2=r[2]*2;
            int y2=r[3]*2;
            
            for(int i=x1;i<=x2;i++){
                for(int j=y1;j<=y2;j++){
                    board[j][i]=1;
                }
            }
        }
        
        for(int[]r:rectangle){
            int x1=r[0]*2;
            int y1=r[1]*2;
            int x2=r[2]*2;
            int y2=r[3]*2;
            
            for(int i=x1+1;i<x2;i++){
                for(int j=y1+1;j<y2;j++){
                    board[j][i]=0;
                }
            }
        }
		// StringBuilder sb = new StringBuilder();
		// for (int i = 0; i < 10; i++) {
		// 	for (int j = 0; j < 10; j++) {
		// 		sb.append(board[j][i]).append(" ");
		// 	}
		// 	sb.append("\n");
		// }
		// System.out.println(sb);
        answer=bfs(characterX*2, characterY*2, itemX*2, itemY*2);
        return answer;
    }
    static int bfs(int sx,int sy,int tx,int ty){
        Queue<int[]>q=new ArrayDeque<>();
        q.add(new int[]{sx,sy,0});
        visited[sy][sx]=true;
        while(!q.isEmpty()){
            int[]cur=q.poll();
            int x=cur[0];
            int y=cur[1];
            int dist=cur[2];
            
            if(x==tx&&y==ty){
                return dist/2;
            }
            for(int i=0;i<4;i++){
                int nx=x+dx[i];
                int ny=y+dy[i];
                
                if(nx<0||nx>=102||ny<0||ny>=102) continue;
                if(!visited[ny][nx] && board[ny][nx]==1){
                    visited[ny][nx]=true;
                    q.add(new int[]{nx,ny,dist+1});
                }
            }
        }
        return 0;
    }
}