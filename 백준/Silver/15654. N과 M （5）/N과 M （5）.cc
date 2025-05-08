#include<bits/stdc++.h>
using namespace std;
vector<int>v,print,visited;
int N,M;
stack<int>st;

void back_track(int cnt){
    if(cnt==M){
        for(int i=0;i<M;i++){
            cout<<print[i]<<" ";
        }
        cout<<"\n";
        return;
    }
    for(int i=0;i<N;i++){
        if(visited[i]==0){
            visited[i]=1;
            print[cnt]=v[i];
            back_track(cnt+1);
            visited[i]=0;
            print[cnt]=-1;
        }
    }
}

int main(){
    cin>>N>>M;
    v.resize(N);
    visited.resize(N,0);
    print.resize(M);
    for(int i=0;i<N;i++){
        cin>>v[i];
    }
    sort(v.begin(),v.begin()+N);
    back_track(0);
    return 0;
}