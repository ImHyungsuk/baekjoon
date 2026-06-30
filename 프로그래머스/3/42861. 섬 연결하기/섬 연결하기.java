import java.util.*;
class Solution {
    static int[]parents;
    public int solution(int n, int[][] costs) {
        int answer = 0;
        parents=new int[n];
        for(int i=0;i<n;i++)parents[i]=i;
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
    void union(int a,int b){
        a=find(a);
        b=find(b);
        if(a<b)parents[b]=a;
        else if(b<a)parents[a]=b;
    }
    int find(int x){
        if(x==parents[x])return x;
        return parents[x]=find(parents[x]);
    }
}