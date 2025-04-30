#include<bits/stdc++.h>
using namespace std;
int V,max_cost=0,max_node;
vector<vector<pair<int,int>>>edges;
vector<bool>visited;

void dfs(int cur_node,int cur_cost){
    if(cur_cost>max_cost){
        max_node=cur_node;
        max_cost=cur_cost;
    }
    for(size_t i=0;i<edges[cur_node].size();i++){
        int next_node=edges[cur_node][i].first;
        int next_cost=edges[cur_node][i].second+cur_cost;
        if(!visited[next_node]){
            visited[next_node]=true;
            dfs(next_node,next_cost);
            visited[next_node]=false;
        }
    }
}

int main(){
    int s,e,c;
    cin>>V;
    edges.resize(V+1);
    for(int i=0;i<V;i++){
        cin>>s;
        while(true){
            cin>>e;
            if(e==-1){
                break;
            }
            cin>>c;
            edges[s].push_back({e,c});
        }
    }

    // for(size_t i=0;i<edges[4].size();i++){
    //     cout<<edges[4][i].first<<" "<<edges[4][i].second<<"\n";
    // }

    visited.resize(V+1,false);
    visited[1]=true;
    dfs(1,0);
    int tmp=max_node;
    // cout<<tmp<<" "<<max_cost<<"\n";

    max_cost=0;
    fill(visited.begin(),visited.end(),false);
    visited[tmp]=true;
    dfs(tmp,0);
    cout<<max_cost;
    return 0;
}