#include<bits/stdc++.h>
using namespace std;
int R,C,ret=0;
vector<vector<char>>table;
vector<int>visited(28,0);

void back_track(int y,int x,int cnt){
    int flag=4;
    if(y-1>=0&&visited[table[y-1][x]-'A']==0){
        flag--;
        visited[table[y-1][x]-'A']=1;
        back_track(y-1,x,cnt+1);
        visited[table[y-1][x]-'A']=0;
    }
    if(y+1<R&&visited[table[y+1][x]-'A']==0){
        flag--;
        visited[table[y+1][x]-'A']=1;
        back_track(y+1,x,cnt+1);
        visited[table[y+1][x]-'A']=0;
    }
    if(x-1>=0&&visited[table[y][x-1]-'A']==0){
        flag--;
        visited[table[y][x-1]-'A']=1;
        back_track(y,x-1,cnt+1);
        visited[table[y][x-1]-'A']=0;
    }
    if(x+1<C&&visited[table[y][x+1]-'A']==0){
        flag--;
        visited[table[y][x+1]-'A']=1;
        back_track(y,x+1,cnt+1);
        visited[table[y][x+1]-'A']=0;
    }
    if(flag==4){
        ret=ret<cnt?cnt:ret;
    }
    return;
}

int main(){
    char input;
    cin>>R>>C;
    table.resize(R,vector<char>(C));
    for(int i=0;i<R;i++){
        for(int j=0;j<C;j++){
            cin>>table[i][j];
        }
    }
    visited[table[0][0]-'A']=1;
    back_track(0,0,1);
    cout<<ret;
    return 0;
}