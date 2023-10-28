#include <iostream>
#include <queue>

using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    int N, K;
    queue<int> st, ret;
    cin >> N >> K;

    for (int i = 0; i < N; i++)
        st.push(i + 1);
    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < K - 1; j++)
        {
            st.push(st.front());
            st.pop();
        }
        ret.push(st.front());
        st.pop();
    }
    cout << "<";
    for (int i = 0; i < N; i++)
    {
        cout << ret.front();
        ret.pop();
        if (i != N - 1)
            cout << ", ";
    }
    cout << ">";

    return 0;
}