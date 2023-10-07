#include <iostream>
#include <stack>

using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie();
    int K;
    int tmp, ret;
    std::stack<int> st;
    cin >> K;
    for (int i = 0; i < K; i++)
    {
        cin >> tmp;
        if (tmp == 0)
        {
            st.pop();
            continue;
        }
        st.push(tmp);
    }
    ret = 0;
    while (!st.empty())
    {
        ret += st.top();
        st.pop();
    }

    cout << ret;
    return 0;
}