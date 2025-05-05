#include<bits/stdc++.h>
using namespace std;

string str;
stack<char>st;

int main(){
    cin>>str;

    int index=0,cnt=0;
    while(index<str.length()){
        if(str[index]>='A'&&str[index]<='Z'){
            cout<<str[index];
        }
        else if(str[index]=='('){
            st.push(str[index]);
        }
        else if(str[index]==')'){
            while(st.top()!='('){
                cout<<st.top();
                st.pop();
            }
            st.pop();
        }
        else if(str[index]=='+'||str[index]=='-'){
            while(!st.empty()&&st.top()!='('){
                cout<<st.top();
                st.pop();
            }
            st.push(str[index]);
        }
        else if(str[index]=='*'||str[index]=='/'){
            while(!st.empty()&&(st.top()=='*'||st.top()=='/')){
                cout<<st.top();
                st.pop();
            }
            st.push(str[index]);
        }
        index++;
    }
    while(!st.empty()){
        cout<<st.top();
        st.pop();
    }

    return 0;
}