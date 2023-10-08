#include <iostream>
#include <stack>

using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    int T;
    string tmp;
    stack<char> st;
    cin >> T;
    for (int i = 0; i < T; i++)
    {
        cin >> tmp;
        // cout << tmp.length();
        for (int j = 0; j < tmp.length(); j++)
        {
            if (tmp[j] == '(')
                st.push(tmp[j]);
            else if (tmp[j] == ')')
            {
                if (st.empty())
                {
                    st.push(tmp[j]);
                    break;
                }
                else
                    st.pop();
            }
        }
        if (st.empty())
            cout << "YES\n";
        else
            cout << "NO\n";
        while (!st.empty())
            st.pop();
    }

    return 0;
}