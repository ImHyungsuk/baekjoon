#include<bits/stdc++.h>
using namespace std;
vector<pair<int,int>>v[1001];
int N,M,s,e;
int dist[1001];
void dijkstra(int start){
    priority_queue<pair<int,int>,vector<pair<int,int>>,greater<pair<int,int>>> pq;
    dist[start]=0;
    pq.push({0,start});
    while(!pq.empty()){
        int now=pq.top().second;
        int dis=pq.top().first;
        pq.pop();
        if(dist[now]<dis){
            continue;
        }
        for(int i=0;i<v[now].size();i++){
            int next=v[now][i].first;
            int nxcost=v[now][i].second+dis;
            if(dist[next]>nxcost){
                pq.push({nxcost,next});
                dist[next]=nxcost;
            }
        }
    }
}

int main(){
    ios::sync_with_stdio(false);
    cin.tie(0);
    int cnt;
    v[0].push_back({0,0});
    fill(dist, dist + 1001, 2147483647);
    cin>>N>>M;
    for(int i=0;i<M;i++){
        cin>>s>>e>>cnt;
        v[s].push_back(make_pair(e,cnt));
    }
    cin>>s>>e;
    dijkstra(s);
    cout<<dist[e];
    return 0;
}