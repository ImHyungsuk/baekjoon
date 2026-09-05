import java.util.*;

class Solution {
    int []parents;
    public int solution(int n, int[][] costs) {
        int answer = 0;
        parents=new int[n];
        for(int i=0;i<n;i++){
            parents[i]=i;
        }
        Arrays.sort(costs,(a,b)->a[2]-b[2]);
        for(int[]c:costs){
            // System.out.println(c[0]+" ? "+c[1]);
            if(find(c[0])!=find(c[1])){
                union(c[0],c[1]);
                answer+=c[2];
            }
        }
        
        return answer;
    }
    
    void union(int a,int b){
        a=find(a);
        b=find(b);
        if(a<b)
            parents[b]=a;
        else parents[a]=b;
    }
    
    int find(int x){
        if(parents[x]==x)return x;
        return parents[x]=find(parents[x]);
    }
}