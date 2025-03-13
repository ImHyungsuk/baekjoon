#include<bits/stdc++.h>
using namespace std;

int main(){
    ios::sync_with_stdio(false);
    cin.tie(0);
    int N,M,tmp,s,e;
    long long sum[100001]={0};
    cin>>N>>M;
    for(int i=0;i<N;i++){
        cin>>tmp;
        sum[i+1]=sum[i]+tmp;
    }
    for(int i=0;i<M;i++){
        cin>>s>>e;
        cout<<sum[e]-sum[s-1]<<"\n";
    }
    return 0;
}