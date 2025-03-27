#include<bits/stdc++.h>
using namespace std;
vector<int> v(100,101);
vector<pair<int,int>>pt(100,make_pair(0,0));
int main(){
    int N,M;
    int s,e;
    cin>>N>>M;
    for(int i=0;i<N;i++){
        cin>>s>>e;
        pt[s-1]=make_pair(e-1,0);
        // cout<<st[e-1].first<<" "<<st[e-1].second<<"\n";
    }
    for(int j=0;j<M;j++){
        cin>>s>>e;
        pt[s-1]=make_pair(e-1,0);
    }
    v[0]=0;
    for(int i=1;i<100;i++){
        for(int j=1;j<7&&(i-j)>=0;j++){
            if(pt[i-j].first==0)
                v[i]=v[i]>v[i-j]+1?v[i-j]+1:v[i];
        }
        if(pt[i].first!=0){
            v[pt[i].first]=v[i]>v[pt[i].first]?v[pt[i].first]:v[i];
            if(pt[i].first<i&&pt[i].second==0){
                pt[i].second=1;
                i=pt[i].first;
            }
        }
    }
    cout<<v[99];
    return 0;
}