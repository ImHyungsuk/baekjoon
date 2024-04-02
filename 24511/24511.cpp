#include <iostream>
#include <stack>
#include <queue>
#include <deque>

using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    int N, M, ret, tmp, cnt = 0, i, j;
    int A[10001], B[10001], C[10001];
    stack<int> st;
    cin >> N;
    for (i = 0; i < N; i++)
    {
        cin >> A[i];
    }
    for (i = 0; i < N; i++)
    {
        cin >> B[i];
        if (A[i] == 0)
        {
            cnt++;
            st.push(B[i]);
        }
    }
    cin >> M;
    for (i = 0; i < M; i++)
    {
        cin >> C[i];
    }
    i = 0;
    j = 0;
    while (j < M)
    {
        if (!st.empty())
        {
            cout << st.top() << ' ';
            st.pop();
        }
        else
        {
            cout << C[i] << ' ';
            i++;
        }
        j++;
    }
    return 0;
}