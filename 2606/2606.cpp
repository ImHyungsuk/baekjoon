#include <bits/stdc++.h>
using namespace std;
int T;
int c[100]={0,};
int arr[100][100]={0,};

void dfs(int s){
    c[s]=1;
    for(int i=0;i<T;i++){
        if(i==s)
            continue;
        if(arr[s][i]==1&&c[i]==0){
            dfs(i);
        }
    
    }
    return;
}

int main(){
    int n1,n2;
    int N,cnt=0;
    cin>>T;
    cin>>N;
    for(int i=0;i<N;i++){
        cin>>n1;
        cin>>n2;
        arr[n1-1][n2-1]=1;
        arr[n2-1][n1-1]=1;
    }
    dfs(0);
    for(int i=1;i<T;i++){
        if(c[i]==1){
            cnt++;
        }
    }
    cout<<cnt;
    return 0;
}