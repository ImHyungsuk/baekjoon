#include<bits/stdc++.h>
using namespace std;
vector<pair<char,char>>v;

void preorder(char cur){
    if(cur=='.')
        return;
    cout<<cur;
    preorder(v[cur-'A'].first);
    preorder(v[cur-'A'].second);
}

void inorder(char cur){
    if(cur=='.')
        return;
    inorder(v[cur-'A'].first);
    cout<<cur;
    inorder(v[cur-'A'].second);
}

void postorder(char cur){
    if(cur=='.')
        return;
    postorder(v[cur-'A'].first);
    postorder(v[cur-'A'].second);
    cout<<cur;
}

int main(){
    int N;
    char root,left,right;
    cin>>N;
    v.resize(N);
    for(int i=0;i<N;i++){
        cin>>root>>left>>right;
        v[root-'A']={left,right};
    }
    preorder('A');
    cout<<"\n";

    inorder('A');
    cout<<"\n";

    postorder('A');
    cout<<"\n";

    return 0;
}