#include <bits/stdc++.h>
using namespace std;

int main()
{
    int n,arr[1001]={0,};
    arr[1]=1;
    arr[2]=2;
    cin >> n;
    for(int i=3;i<=n;i++){
        arr[i]=(arr[i-1]+arr[i-2])%10007;
    }
    cout<<arr[n];
    return 0;
}