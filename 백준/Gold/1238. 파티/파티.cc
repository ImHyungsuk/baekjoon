#include<bits/stdc++.h>
using namespace std;
int N,M,X;
vector<int>total_time,go_time,come_time;
vector<vector<pair<int,int>>>v;
struct edge{
    int s,e,c;
};

// void Djikstra(int s){
//     go_time.resize(N+1,1000001);
//     go_time[s]=0;
//     priority_queue<pair<int,int>,vector<pair<int,int>>,greater<>>pq;
//     pq.push({0,s});
//     while(!pq.empty()){
//         int cur_node,cur_cost;
//         cur_cost=pq.top().first;
//         cur_node=pq.top().second;
//         pq.pop();
//         if(cur_cost>go_time[cur_node]){
//             continue;
//         }
//         if(cur_node==X){
//             break;
//         }
//         for(size_t i=0;i<v[cur_node].size();i++){
//             int next_node,next_cost;
//             next_node=v[cur_node][i].first;
//             next_cost=v[cur_node][i].second+cur_cost;
//             if(next_node==s){
//                 continue;
//             }
//             if(go_time[next_node]>next_cost){
//                 pq.push({next_cost,next_node});
//                 go_time[next_node]=next_cost;
//             }
//         }
//     }
//     total_time[s]+=go_time[X];
// }

void Bellman_Ford(vector<edge>edges){
    go_time.resize(N+1,1000001);
    go_time[X]=0;
    come_time.resize(N+1,1000001);
    come_time[X]=0;
    for(int i=1;i<N;i++){
        for(int j=0;j<M;j++){
            int start,end,cost;
            start=edges[j].s;
            end=edges[j].e;
            cost=edges[j].c;
            if(come_time[start]!=1000001 && come_time[end]>come_time[start]+cost){
                come_time[end]=come_time[start]+cost;
            }
            start=edges[j].e;
            end=edges[j].s;
            cost=edges[j].c;
            if(go_time[start]!=1000001 && go_time[end]>go_time[start]+cost){
                go_time[end]=go_time[start]+cost;
            }
        }
    }
    for(int i=1;i<N+1;i++){
        total_time[i]+=come_time[i]+go_time[i];
    }
}

int main(){
    int s,e,c;
    vector<edge>edges;
    cin>>N>>M>>X;
    v.resize(N+1);
    edges.resize(M);
    for(int i=0;i<M;i++){
        cin>>s>>e>>c;
        edges[i]={s,e,c};
        v[s].push_back({e,c});
    }
    total_time.resize(N+1,0);
    // for(int i=1;i<N+1;i++){
    //     if(i==X){
    //         continue;
    //     }
    //     Djikstra(i);
    // }
    Bellman_Ford(edges);
    int max_value=0;
    for(int i=1;i<N+1;i++){
        if(i==X){
            continue;
        }
        if(max_value<total_time[i]){
            max_value=total_time[i];
        }
    }
    cout<<max_value;
    return 0;
}