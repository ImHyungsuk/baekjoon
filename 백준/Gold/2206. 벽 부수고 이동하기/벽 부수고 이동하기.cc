#include<bits/stdc++.h>
using namespace std;

int N,M,min_value=1000001;
vector<vector<char>>m;
vector<vector<vector<int>>>visited;

void bfs(){
    queue<pair<pair<int,int>,pair<int,int>>>q;
    q.push({{0,0},{1,0}});
    while(!q.empty()){
        int x=q.front().first.first;
        int y=q.front().first.second;
        int cost=q.front().second.first;
        int cnt=q.front().second.second;
        q.pop();
        if(x==M-1&&y==N-1){
            min_value=min_value<cost?min_value:cost;
            return;
        }
        if(x-1>=0){
            if(m[y][x-1]=='1'&&cnt==0){
                q.push({{x-1,y},{cost+1,cnt+1}});
                visited[y][x-1][cnt]=1;
            }
            else if(m[y][x-1]=='0'&&visited[y][x-1][cnt]==0){
                q.push({{x-1,y},{cost+1,cnt}});
                visited[y][x-1][cnt]=1;
            }
        }
        if(x+1<M){
            if(m[y][x+1]=='1'&&cnt==0){
                q.push({{x+1,y},{cost+1,cnt+1}});
                visited[y][x+1][cnt+1]=1;
            }
            else if(m[y][x+1]=='0'&&visited[y][x+1][cnt]==0){
                q.push({{x+1,y},{cost+1,cnt}});
                visited[y][x+1][cnt]=1;
            }
        }
        if(y-1>=0){
            if(m[y-1][x]=='1'&&cnt==0){
                q.push({{x,y-1},{cost+1,cnt+1}});
                visited[y-1][x][cnt+1]=1;
            }
            else if(m[y-1][x]=='0'&&visited[y-1][x][cnt]==0){
                q.push({{x,y-1},{cost+1,cnt}});
                visited[y-1][x][cnt]=1;
            }
        }
        if(y+1<N){
            if(m[y+1][x]=='1'&&cnt==0){
                q.push({{x,y+1},{cost+1,cnt+1}});
                visited[y+1][x][cnt+1]=1;
            }
            else if(m[y+1][x]=='0'&&visited[y+1][x][cnt]==0){
                q.push({{x,y+1},{cost+1,cnt}});
                visited[y+1][x][cnt]=1;
            }
        }
    }
}

int main(){
    cin>>N>>M;
    m.resize(N,vector<char>(M));
    visited.resize(N,vector<vector<int>>(M,vector<int>(2,0)));
    for(int i=0;i<N;i++){
        for(int j=0;j<M;j++){
            cin>>m[i][j];
        }
    }
    visited[0][0][0]=1;
    bfs();
    cout<<(min_value==1000001?-1:min_value);

    return 0;
}