#include<bits/stdc++.h>
using namespace std;

int main(){
    int N,M,max=0,input;
    vector<int>v;
    cin>>N>>M;
    for(int i=0;i<N;i++){
        cin>>input;
        max=max>input?max:input;
        v.push_back(input);
    }
    long long top=max,bottom=0,cut=top/2;
    while(top>=bottom){
        long long sum=0;
        for(size_t i=0;i<v.size();i++){
            sum+=(v[i]-cut)<0?0:v[i]-cut;
        }
        if(sum>=M){
            input=cut;
            bottom=cut+1;
        }
        else if(sum<M){
            top=cut-1;
        }
        cut=(top+bottom)/2;
    }
    cout<<input;
    return 0;
}