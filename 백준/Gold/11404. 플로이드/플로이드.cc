#include<bits/stdc++.h>
using namespace std;
int n,m;
vector<vector<pair<int,int>>>edges;
vector<vector<int>>v;

void floyd_warshall(int start){
    priority_queue<pair<int,int>,vector<pair<int,int>>,greater<>>pq;
    pq.push({0,start});
    while(!pq.empty()){
        int cur_node=pq.top().second;
        int cur_cost=pq.top().first;
        pq.pop();
        if(v[start][cur_node]!=0 && cur_cost>v[start][cur_node]){
            continue;
        }
        if(cur_cost<v[start][cur_node] || v[start][cur_node]==0){
            // cout<<"왜 안들어와 시발\n";
            v[start][cur_node]=cur_cost;
        }
        for(size_t i=0;i<edges[cur_node].size();i++){
            int next_node=edges[cur_node][i].first;
            int next_cost=edges[cur_node][i].second+cur_cost;
            // cout<<"gg "<<cur_node<<" "<<next_node<<" "<<next_cost<<"\n";
            if(next_node==start){
                continue;
            }
            if(next_cost<v[start][next_node]|| v[start][next_node]==0){
                // cout<<cur_node<<" "<<next_node<<" "<<next_cost<<"\n";
                v[start][next_node]=next_cost;
                pq.push({next_cost,next_node});
            }
        }
    }

}

int main(){
    int a,b,c;
    cin>>n>>m;
    edges.resize(n+1);
    for(int i=0;i<m;i++){
        cin>>a>>b>>c;
        edges[a].push_back({b,c});
    }
    // for(size_t i=0;i<edges[1].size();i++){
    //     cout<<edges[1][i].first<<" "<<edges[1][i].second <<"\n";
    // }
    v.resize(n+1,vector<int>(n+1,0));
    for(int i=1;i<=n;i++){
        floyd_warshall(i);
    }

    for(int i=1;i<=n;i++){
        for(int j=1;j<=n;j++){
            cout<<v[i][j]<<" ";
        }
        cout<<"\n";
    }
    return 0;
}