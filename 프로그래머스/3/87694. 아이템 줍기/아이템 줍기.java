import java.util.*;
class Solution {
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        int[][]map=new int[101][101];
        for(int[]r:rectangle){
            int x1=r[0]*2,y1=r[1]*2;
            int x2=r[2]*2,y2=r[3]*2;
            for(int x=x1;x<=x2;x++){
                for(int y=y1;y<=y2;y++){
                    if((x==x1||x==x2||y==y1||y==y2)&&map[y][x]!=-1) map[y][x]=1;
                    else map[y][x]=-1;
                }
            }
        }
        // StringBuilder sb=new StringBuilder();
        // for(int i=0;i<=10;i++){
        //     for(int j=0;j<=10;j++){
        //         sb.append(map[j][i]).append("\t");
        //     }
        //     sb.append("\n");
        // }
        // System.out.println(sb);
        answer=bfs(map,characterX*2,characterY*2,itemX*2,itemY*2);
        return answer;
    }
    int bfs(int[][]map,int cX,int cY,int iX,int iY){
        boolean[][]visited=new boolean[101][101];
        int[]dx={-1,1,0,0};
        int[]dy={0,0,-1,1};
        Queue<int[]>q=new LinkedList<>();
        q.add(new int[]{cY,cX,0});
        visited[cY][cX]=true;
        while(!q.isEmpty()){
            int[]cur=q.poll();
            // System.out.println(cur[0]+" "+cur[1]+" "+cur[2]);
            if(cur[0]==iY&&cur[1]==iX){
                return cur[2]/2;
            }
            for(int i=0;i<4;i++){
                int ny=cur[0]+dy[i];
                int nx=cur[1]+dx[i];
                
                if(ny<0||nx<0||ny>100||nx>100||map[ny][nx]!=1||visited[ny][nx])continue;
                q.add(new int[]{ny,nx,cur[2]+1});
                visited[ny][nx]=true;
            }
        }
        return -1;
    }
}