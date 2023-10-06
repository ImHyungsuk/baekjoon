#include <iostream>
#include <stack>

using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    int N, tmp1, tmp2;
    stack<int> st;
    cin >> N;
    for (int i = 0; i < N; i++)
    {
        cin >> tmp1;
        if (tmp1 == 1)
        {
            cin >> tmp2;
            st.push(tmp2);
        }
        else if (tmp1 == 2)
        {
            if (st.empty())
                cout << -1 << '\n';
            else
            {
                cout << st.top() << '\n';
                st.pop();
            }
        }
        else if (tmp1 == 3)
            cout
                << st.size() << '\n';
        else if (tmp1 == 4)
        {
            if (st.empty())
                cout << 1 << '\n';
            else
                cout << 0 << '\n';
        }
        else if (tmp1 == 5)
        {
            if (st.empty())
                cout << -1 << '\n';
            else
                cout << st.top() << '\n';
        }
    }

    return 0;
}