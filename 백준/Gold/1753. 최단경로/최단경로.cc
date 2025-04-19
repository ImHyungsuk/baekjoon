#include<bits/stdc++.h>
using namespace std;

int V,E,K,u,v,w;
vector<vector<pair<int,int>>>graph(20001);
vector<int>dist;

void djikstra(int start){
    priority_queue<pair<int,int>,vector<pair<int,int>>,greater<>>pq;
    int cur_node=start,cur_dist=0;
    dist[cur_node]=0;
    pq.push({cur_dist,cur_node});
    
    while(!pq.empty()){
        cur_dist=pq.top().first;
        cur_node=pq.top().second;
        pq.pop();
        if(cur_dist>dist[cur_node]){
            continue;
        }
        for(size_t i=0;i<graph[cur_node].size();i++){
            int nx_node,nx_dist;
            nx_node=graph[cur_node][i].first;
            nx_dist=graph[cur_node][i].second+cur_dist;
            if(nx_dist<dist[nx_node]){
                dist[nx_node]=nx_dist;
                pq.push({dist[nx_node],nx_node});
            }
        }
    }

}

int main(){
    ios::sync_with_stdio(false);
    cin.tie(0);
    cin>>V>>E>>K;
    dist.resize(V+1,INT_MAX);
    for(int i=0;i<E;i++){
        cin>>u>>v>>w;
        graph[u].push_back({v,w});
    }
    djikstra(K);
    for(int i=1;i<V+1;i++){
        if(dist[i]==INT_MAX){
            cout<<"INF\n";
        }
        else{
            cout<<dist[i]<<"\n";
        }
    }
    return 0;
}