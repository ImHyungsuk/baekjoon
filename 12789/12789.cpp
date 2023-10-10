#include<iostream>
#include<stack>

using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    int N,tmp,n,i;
    int wait[1001] = {0,};
    stack <int> st;
    cin >> N;
    n = 1;
    for(i = 0; i < N; i++)
        cin >> wait[i];
    
    i = 0;
    while(n <= N && i <= N)
    {
        // cout << n << " turn\n";
        if (wait[i] == n)
        {
            while(wait[i] == n)
            {
                // cout << n << " pass\n";
                i++;
                n++;
            }
        }
        else if(!st.empty() && st.top() == n)
        {
            while(!st.empty() && st.top() == n)
            {
                // cout << n << " pass\n";
                st.pop();
                n++;
            }
            st.push(wait[i]);
            i++;
        }
        else if(!st.empty() && st.top() < wait[i])
            break;
        else
        {
            // cout << wait[i] << " wait\n";
            st.push(wait[i]);
            i++;
        }
    }
    if(n == N + 1)
        cout << "Nice";
    else
        cout << "Sad";

    return 0;
}