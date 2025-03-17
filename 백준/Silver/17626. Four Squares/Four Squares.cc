#include<bits/stdc++.h>
using namespace std;

int main(){
    int n;
    cin>>n;
    vector<int>v (n+1,0);
    v[1]=1;
    for(int i=2;i<=n;i++){
        v[i]=v[i-1]+1;
        for(int j=1;j*j<=i;j++){
            // cout<<"i = "<<i<<" j = "<<j<<"\n";
            int tmp=i-j*j;
            v[i]=v[i]<(v[tmp]+1)?v[i]:v[tmp]+1;
        // cout<<v[i]<<"\n";
        }
    }
    cout<<v[n];
    return 0;
}