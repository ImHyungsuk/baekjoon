#include<bits/stdc++.h>
using namespace std;

bool isLCS(vector<char>&LCS,string &s1){
    size_t it=0;
    int index=0;
    while(it<LCS.size()){
        bool flag=false;
        while(index<s1.length()){
            if(LCS[it]==s1[index]){
                flag=true;
                break;
            }
            index++;
        }
        if(flag){
            it++;
            index++;
        }
        else{
            return false;
        }
    }
    return true;
}

int main(){
    string s1,s2;
    vector<vector<int>>dp;
    cin>>s1>>s2;
    dp.resize(s1.length()+1,vector<int>(s2.length()+1,0));
    for(int i=1;i<=s1.length();i++){
        for(int j=1;j<=s2.length();j++){
            if(s1[i-1]==s2[j-1]){
                dp[i][j]=dp[i-1][j-1]+1;
            }
            int tmp=dp[i-1][j]>dp[i][j-1]?dp[i-1][j]:dp[i][j-1];
            dp[i][j]=dp[i][j]<tmp?tmp:dp[i][j];
        }
    }
    cout<<dp[s1.length()][s2.length()];
    return 0;
}