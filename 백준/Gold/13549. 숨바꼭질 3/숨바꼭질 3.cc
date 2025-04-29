#include<bits/stdc++.h>
using namespace std;

vector<int>v(100001,100000);
int N,K;

void bfs(){
    priority_queue<pair<int,int>,vector<pair<int,int>>,greater<>>pq;
    v[N]=0;
    pq.push({v[N],N});
    while(!pq.empty()){
        int cur_time=pq.top().first;
        int cur_index=pq.top().second;
        pq.pop();
        if(cur_index==K){
            return;
        }
        if(v[cur_index]<cur_time){
            continue;
        }
        if(2*cur_index<100001 && v[2*cur_index]>cur_time){
            v[2*cur_index]=cur_time;
            pq.push({cur_time,2*cur_index});
        }
        if(cur_index+1<100001 && v[cur_index+1]>cur_time+1){
            v[cur_index+1]=cur_time+1;
            pq.push({cur_time+1,cur_index+1});
        }
        if(cur_index-1>0 && v[cur_index-1]>cur_time+1){
            v[cur_index-1]=cur_time+1;
            pq.push({cur_time+1,cur_index-1});
        }
    }
}

int main(){
    cin>>N>>K;
    if(N<K){
        bfs();
        cout<<v[K]<<"\n";
    }
    else{
        cout<<N-K<<"\n";
    }
    return 0;
}