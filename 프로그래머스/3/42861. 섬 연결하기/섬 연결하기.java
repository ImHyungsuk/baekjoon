import java.util.*;
class Solution {
    int[]parents;
    public int solution(int n, int[][] costs) {
        int answer = 0;
        Arrays.sort(costs,(int[]a,int[]b)->a[2]-b[2]);
        parents=new int[n];
        for(int i=0;i<n;i++){
            parents[i]=i;
        }
        int cnt=costs.length;
        for(int i=0;i<cnt;i++){
            int x=costs[i][0];
            int y=costs[i][1];
            if(find(x)!=find(y)){
                union(x,y);
                answer+=costs[i][2];
            }
        }
        return answer;
    }
    void union(int x,int y){
        x=find(x);
        y=find(y);
        if(x<y)parents[y]=x;
        else parents[x]=y;
    }
    int find(int a){
        if(parents[a]!=a)return parents[a]=find(parents[a]);
        return a;
    }
}