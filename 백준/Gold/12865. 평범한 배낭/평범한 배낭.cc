#include<bits/stdc++.h>
using namespace std;
int N,K,W,V,max_value=0;
vector<vector<int>>dp;
vector<pair<int,int>>product_list;

void calculate_dp(){
    for(int i=1;i<K+1;i++){
        for(int j=0;j<N;j++){
            int weight,value;
            weight=product_list[j].first;
            value=product_list[j].second;
            if(weight>i){
                dp[i][j]=dp[i][j-1];
            }
            else{
                // if(i==K){
                //     cout<<j<<" "<<i-weight<<" "<<dp[i-weight][j]<<" "<<value<<"\n";
                // }
                dp[i][j]=dp[i][j-1]>dp[i-weight][j-1]+value?dp[i][j-1]:dp[i-weight][j-1]+value;
                // if(i==4){
                //     cout<<j<<" "<<i-weight<<" "<<dp[i-weight][j]<<" "<<value<<"\n";
                // }
            }
        }
    }
}

int main(){
    cin>>N>>K;
    product_list.resize(N);
    dp.resize(K+1,vector<int>(N,0));
    for(int i=0;i<N;i++){
        cin>>W>>V;
        product_list[i]={W,V};
    }
    calculate_dp();
    for(int i=0;i<N;i++){
        // cout<<dp[K][i]<<" ";
        max_value=max_value<dp[K][i]?dp[K][i]:max_value;
    }
    cout<<max_value;
    return 0;
}