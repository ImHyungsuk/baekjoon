#include<bits/stdc++.h>
using namespace std;
int main(){
    ios::sync_with_stdio(false);
    cin.tie(0);
    long long int arr[101]={0,};
    int T,N;
    cin>>T;
    arr[1]=1;
    arr[2]=1;
    arr[3]=1;
    arr[4]=2;
    arr[5]=2;
    for(int i=0;i<T;i++){
        cin>>N;
        if(N<=5){
            cout<<arr[N]<<"\n";
        }
        else{
            for(int j=6;j<=N;j++){
                arr[j]=arr[j-1]+arr[j-5];
            }
            cout<<arr[N]<<"\n";
        }
    }
    return 0;
}