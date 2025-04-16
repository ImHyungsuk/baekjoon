#include<bits/stdc++.h>
using namespace std;

int N,E,a,b,c,v1,v2;
int minRoute=INT_MAX;
vector<pair<int,int>>arr[801];
vector<int>dp;

void calculate(int start){
    queue<pair<int,int>>q;
    q.push({start,0});
    while(!q.empty()){
        int cur=q.front().first;
        int distance=q.front().second;
        q.pop();
        if(dp[cur]>distance){
            dp[cur]=distance;
        }
        else continue;
        for(size_t idx=0;idx<arr[cur].size();idx++){
            int next=arr[cur][idx].first;
            int next_distance=arr[cur][idx].second+distance;
            if(dp[next]>next_distance){
                q.push({next,next_distance});
            }
        }
    }
}

int main(){
    cin>>N>>E;
    dp.resize(N+1,INT_MAX);
    for(int i=0;i<E;i++){
        cin>>a>>b>>c;
        arr[a].push_back({b,c});
        arr[b].push_back({a,c});
    }
    cin>>v1>>v2;
    int firstRoute=0,secondRoute=0;
    calculate(1);
    if(dp[v1]==INT_MAX||dp[v2]==INT_MAX||dp[N]==INT_MAX){
        cout<<-1;
        return 0;
    }
    firstRoute+=dp[v1];
    secondRoute+=dp[v2];
    for(int i=0;i<=N;i++){
        dp[i]=INT_MAX;
    }
    calculate(v1);
    if(dp[v2]==INT_MAX||dp[N]==INT_MAX){
        cout<<-1;
        return 0;
    }
    firstRoute+=dp[v2];
    secondRoute+=dp[N];
    for(int i=0;i<=N;i++){
        dp[i]=INT_MAX;
    }
    calculate(v2);
    if(dp[N]==INT_MAX){
        cout<<-1;
        return 0;
    }
    firstRoute+=dp[N];
    secondRoute+=dp[v1];

    cout<<(firstRoute<secondRoute?firstRoute:secondRoute);
    return 0;
}