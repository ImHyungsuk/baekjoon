import java.util.*;
class Solution {
    static int[]parent;
    public int solution(int n, int[][] costs) {
        int answer = 0;
        parent =new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
        Arrays.sort(costs,(c1,c2)->c1[2]-c2[2]);
        int cnt=0;
        for(int i=0;i<costs.length;i++){
            int a=costs[i][0];
            int b=costs[i][1];
            if(find(a)!=find(b)){
                union(a,b);
                answer+=costs[i][2];
                cnt++;
                if(cnt==n-1)break;
            }
        }
        return answer;
    }
    
    static int find(int x){
        if(parent[x]==x)return x;
        return parent[x]=find(parent[x]);
    }
    
    static void union(int a,int b){
        a=find(a);
        b=find(b);
        if(a<b)parent[b]=a;
        else if(a>b)parent[a]=b;
    }
}