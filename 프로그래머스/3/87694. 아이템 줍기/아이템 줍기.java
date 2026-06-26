import java.util.*;
class Solution {
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        int[][] map=new int [101][101];
        for(int i=0;i<rectangle.length;i++){
            int x1=rectangle[i][0]*2;
            int y1=rectangle[i][1]*2;
            int x2=rectangle[i][2]*2;
            int y2=rectangle[i][3]*2;
            for(int x=x1;x<=x2;x++){
                for(int y=y1;y<=y2;y++){
                    if(x==x1||x==x2||y==y1||y==y2){
                        if(map[y][x]==2)continue;
                        map[y][x]=1;
                    }
                    else map[y][x]=2;
                }
            }
        }
        // StringBuilder sb= new StringBuilder();
        // for(int i=1;i<21;i++){
        //     for(int j=1;j<21;j++){
        //         sb.append(map[j][i]).append(" ");
        //     }
        //     sb.append("\n");
        // }
        // System.out.println(sb);
        answer=bfs(map, characterX*2,characterY*2, itemX*2,itemY*2)/2;
        return answer;
    }
    
    int bfs(int [][]map,int characterX, int characterY, int itemX, int itemY){
        int[]dx={-1,1,0,0};
        int[]dy={0,0,-1,1};
        Queue<Node>q=new LinkedList<>();
        boolean[][]visited=new boolean[map.length][map[0].length];
        
        q.add(new Node(characterX,characterY,0));
        visited[characterY][characterX]=true;
        
        while(!q.isEmpty()){
            Node cur=q.poll();
            int curX=cur.x;
            int curY=cur.y;
            int curC=cur.cost;
            // System.out.printf("x: %d, y: %d, cost:%d\n",curX,curY,curC);
            if(curX==itemX&&curY==itemY){
                return curC;
            }
            for(int i=0;i<4;i++){
                int nx=curX+dx[i];
                int ny=curY+dy[i];
                if(nx<0||ny<0||nx>100||ny>100||map[ny][nx]!=1||visited[ny][nx])continue;
                q.add(new Node(nx,ny,curC+1));
                visited[ny][nx]=true;
            }
        }
        return -1;
    }
}

class Node{
    int x, y, cost;
    Node(int x, int y, int cost){
        this.x=x;
        this.y=y;
        this.cost=cost;
    }
}