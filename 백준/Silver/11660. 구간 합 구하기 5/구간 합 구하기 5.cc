#include<bits/stdc++.h>
using namespace std;

int main(){
    int N,M,input,x1,y1,x2,y2;
    vector<vector<int>>v;
    vector<int>ret;
    cin>>N>>M;
    v.resize(N+1,vector<int>(N+1,0));
    ret.resize(M,0);
    for(int i=1;i<N+1;i++){
        for(int j=1;j<N+1;j++){
            cin>>input;
            v[i][j]=v[i][j-1]+v[i-1][j]+input-v[i-1][j-1];
        }
    }
    for(int i=0;i<M;i++){
        cin>>x1>>y1>>x2>>y2;
        ret[i]=v[x2][y2]-v[x1-1][y2]-v[x2][y1-1]+v[x1-1][y1-1];
    }
    for(int i=0;i<M;i++){
        cout<<ret[i]<<"\n";
    }
    return 0;
}