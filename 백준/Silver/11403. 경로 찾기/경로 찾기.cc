#include<bits/stdc++.h>
using namespace std;
int N;
int visited[100];
vector<int>v[100];

void dfs(int s){
    for(size_t i=0;i<v[s].size();i++){
        if(visited[v[s][i]]==0){
            visited[v[s][i]]=1;
            dfs(v[s][i]);
        }
    }
}

int main(){
    int a;
    cin>>N;
    for(int i=0;i<N;i++){
        for(int j=0;j<N;j++){
            cin>>a;
            if(a)
                v[i].push_back(j);
        }
    }
    for(int i=0;i<N;i++){
        for(int j=0;j<N;j++){
            visited[j]=0;
        }
        dfs(i);
        for(int j=0;j<N;j++){
            cout<<visited[j]<<" ";
        }
        cout<<"\n";
    }

    return 0;
}