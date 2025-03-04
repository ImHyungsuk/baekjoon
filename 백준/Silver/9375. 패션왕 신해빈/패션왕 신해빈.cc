#include <bits/stdc++.h>
using namespace std;
map<string, int>m;

int main(){
    ios::sync_with_stdio(false);
    cin.tie(0);
    int T;
    int n,cnt=0;
    string costume,category;
    cin>>T;
    for(int i=0;i<T;i++){
        cin>>n;
        for(int j=0;j<n;j++){
            cin>>costume>>category;
            if(m.find(category)!=m.end()){
                m[category]++;
            }else{
                m.insert(make_pair(category,1));
                cnt++;
            }
        }
        int sum=1;
        for(auto it=m.begin();it!=m.end();++it){
            int value=it->second;
            sum*=(value+1);
            // cout<<"value: "<<value<<" sum: "<<sum<<"\n";
        }
        cout<<sum-1<<"\n";
        m.clear();
    }
    return 0;
}