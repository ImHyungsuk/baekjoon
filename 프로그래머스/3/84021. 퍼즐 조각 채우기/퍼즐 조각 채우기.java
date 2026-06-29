import java.util.*;
class Solution {
    static int[]dx={-1,1,0,0};
    static int[]dy={0,0,-1,1};
    public int solution(int[][] game_board, int[][] table) {
        int answer = 0;
        int l=table.length;
        ArrayList<ArrayList<int[]>> blanks=new ArrayList<>();
        ArrayList<ArrayList<int[]>> pieces=new ArrayList<>();
        boolean[][]board_visited=new boolean[l][l];
        boolean[][]table_visited=new boolean[l][l];
        for(int i=0;i<l;i++){
            for(int j=0;j<l;j++){
                if(!board_visited[i][j]&&game_board[i][j]==0){
                    blanks.add(bfs(game_board,board_visited,j,i,0));
                }
                if(!table_visited[i][j]&&table[i][j]==1){
                    pieces.add(bfs(table,table_visited,j,i,1));
                }
            }
        }
        
        boolean[]used=new boolean[pieces.size()];
        for(ArrayList<int[]>b:blanks){
            for(int idx=0;idx<pieces.size();idx++){
                if(used[idx])continue;
                ArrayList<int[]>p=pieces.get(idx);
                if(b.size()!=p.size())continue;
                for(int r=0;r<4;r++){
                    boolean flag=true;
                    rotate(p);
                    for(int i=0;i<b.size();i++){
                        if(b.get(i)[0]!=p.get(i)[0]||b.get(i)[1]!=p.get(i)[1]){
                            flag=false;
                            break;
                        }
                    }
                    if(flag){
                        used[idx]=true;
                        answer+=p.size();
                        break;
                    }
                }
                if(used[idx])break;
            }
        }
        return answer;
    }
    
    ArrayList<int[]>bfs(int[][]map,boolean[][]visited,int x,int y,int target){
        ArrayList<int[]>arr=new ArrayList<>();
        int l=map.length;
        Queue<int[]>q=new LinkedList<>();
        q.add(new int[]{x,y});
        visited[y][x]=true;
        while(!q.isEmpty()){
            int[]cur=q.poll();
            arr.add(cur);
            for(int i=0;i<4;i++){
                int nx=cur[0]+dx[i];
                int ny=cur[1]+dy[i];
                if(nx<0||ny<0||nx>=l||ny>=l||visited[ny][nx]||map[ny][nx]!=target)continue;
                visited[ny][nx]=true;
                q.add(new int[]{nx,ny});
            }
        }
        normalize(arr);
        return arr;
    }
    void normalize(ArrayList<int[]>arr){
        int minX=Integer.MAX_VALUE,minY=Integer.MAX_VALUE;
        for(int[]a:arr){
            if(minX>a[0]){
                minX=a[0];
                minY=Math.min(minY,a[1]);
            }
        }
        for(int[]a:arr){
            a[0]-=minX;
            a[1]-=minY;
        }
        arr.sort((a,b)->{
            if(a[0]==b[0])return a[1]-b[1];
            else return a[0]-b[0];
        });
    }
        
    void rotate(ArrayList<int[]>arr){
        for(int[]a:arr){
            int tmp=a[0];
            a[0]=-a[1];
            a[1]=tmp;
        }
        normalize(arr);
    }
}