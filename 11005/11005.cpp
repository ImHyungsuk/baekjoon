#include <bits/stdc++.h>
using namespace std;

int main()
{
    int N, B, tmp;
    stack<char> st;
    cin >> N >> B;
    while (N)
    {
        tmp = N % B;
        if (tmp < 10)
            st.push(tmp + 48);
        else
            st.push(tmp + 55);
        N /= B;
    }
    while (!st.empty())
    {
        cout << st.top();
        st.pop();
    }
    return 0;
}