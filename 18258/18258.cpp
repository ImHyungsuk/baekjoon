#include <iostream>
#include <queue>

using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    queue<int> st;
    string tmp1;
    int tmp2;
    int N;
    cin >> N;
    for (int i = 0; i < N; i++)
    {
        cin >> tmp1;
        if (tmp1 == "push")
        {
            cin >> tmp2;
            st.push(tmp2);
        }
        else if (tmp1 == "pop")
        {
            if (st.empty())
                cout << "-1\n";
            else
            {
                cout << st.front() << "\n";
                st.pop();
            }
        }
        else if (tmp1 == "size")
            cout << st.size() << "\n";
        else if (tmp1 == "empty")
        {
            if (st.empty())
                cout << "1\n";
            else
                cout << "0\n";
        }
        else if (tmp1 == "front")
        {
            if (st.empty())
                cout << "-1\n";
            else
                cout << st.front() << "\n";
        }
        else if (tmp1 == "back")
        {
            if (st.empty())
                cout << "-1\n";
            else
                cout << st.back() << "\n";
        }
    }

    return 0;
}