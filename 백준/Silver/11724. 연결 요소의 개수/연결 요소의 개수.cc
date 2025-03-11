#include<bits/stdc++.h>
using namespace std;
int N,M,u,v,cnt=0;
int visited[1001]={0,};

void dfs(vector<vector<int>>&v,int s){
    visited[s]=1;
    for(int j=0;j<v[s].size();j++){
        if(visited[v[s][j]]==0)
            dfs(v,v[s][j]);
    }
}

int main(){
    cin>>N>>M;
    vector<vector<int>>graph(1001);

    for(int i=0;i<M;i++){
        cin>>u>>v;
        graph[u].push_back(v);
        graph[v].push_back(u);
    }
    for(int i=1;i<=N;i++){
        if(visited[i]==0){
            cnt++;
            dfs(graph,i);
        }
    }
    cout<<cnt;
    return 0;
}