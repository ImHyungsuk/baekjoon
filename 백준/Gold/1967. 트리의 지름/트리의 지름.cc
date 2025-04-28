#include<bits/stdc++.h>
using namespace std;
int n,first,second,max_value=0;
vector<vector<pair<int,int>>>edges;
vector<int>node(2);
vector<bool>visited;

void dfs(int cur,int dist,int index){
    if(dist>max_value){
        max_value=dist;
        node[index]=cur;
    }
    for(size_t i=0;i<edges[cur].size();i++){
        int next_node=edges[cur][i].first;
        if(!visited[next_node]){
            visited[next_node]=true;
            dfs(next_node,dist+edges[cur][i].second,index);
            visited[next_node]=false;
        }
    }
}

int main(){
    int s,e,c;
    cin>>n;
    edges.resize(n+1);
    visited.resize(n+1,false);
    for(int i=0;i<n-1;i++){
        cin>>s>>e>>c;
        edges[s].push_back({e,c});
        edges[e].push_back({s,c});
    }
    visited[1]=true;
    dfs(1,0,0);
    visited[1]=false;
    visited[node[0]]=true;
    dfs(node[0],0,1);
    cout<<max_value;
    return 0;
}