#include <iostream>
#include <queue>

using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    int N;
    queue<int> st;
    cin >> N;
    for (int i = 0; i < N; i++)
        st.push(i + 1);
    while (st.size() != 1)
    {
        st.pop();
        st.push(st.front());
        st.pop();
    }
    cout << st.front();

    return 0;
}