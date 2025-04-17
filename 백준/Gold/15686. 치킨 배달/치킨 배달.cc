#include<iostream>
#include<vector>
#include<limits.h>

using namespace std;

int N,M,num,minimum=INT_MAX;
vector<pair<int,int>>house,chicken;
vector<int>visited,track;
vector<vector<int>>dist;

int calculate(){
    int dis=0;
    for (size_t i=0;i<house.size();i++){
        int tmp=dist[i][track[0]];
        for(int j=1;j<M;j++){
            tmp=tmp>dist[i][track[j]]?dist[i][track[j]]:tmp;
        }
        dis+=tmp;
    }
    return dis;
}

void selectChicken(int s,int cnt){
    if(cnt==M){
        int dis=calculate();
        minimum=minimum>dis?dis:minimum;
        return;
    }
    for(int i=s+1;i<chicken.size();i++){
        if(visited[i]==0){
            visited[i]++;
            track[cnt]=i;
            selectChicken(i,cnt+1);
            visited[i]--;
        }
    }
}

int main(){
    cin>>N>>M;
    track.resize(M,0);
    for(int i=0;i<N;i++){
        for(int j=0;j<N;j++){
            cin>>num;
            if(num==1){
                house.push_back({i,j});
            }
            else if(num==2){
                chicken.push_back({i,j});
            }
        }
    }

    dist.resize(house.size(),vector<int>(chicken.size()));
    visited.resize(chicken.size(),0);
    for(size_t i=0;i<house.size();i++){
        for(size_t j=0;j<chicken.size();j++){
            int x_h,y_h,x_c,y_c;
            x_h=house[i].first;
            y_h=house[i].second;
            x_c=chicken[j].first;
            y_c=chicken[j].second;
            int x=x_h-x_c;
            int y=y_h-y_c;
            x=x<0?x*(-1):x;
            y=y<0?y*(-1):y;
            dist[i][j]=x+y;
        }
    }
    selectChicken(-1,0);
    cout<<minimum;
    return 0;
}