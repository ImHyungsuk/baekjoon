#include "bits/stdc++.h"
using namespace std;
int arr[9];

void dfs(int N, int M, int cnt, int s)
{
    if (cnt == M)
    {
        for (int i = 0; i < M; i++)
        {
            cout << arr[i] << " ";
        }
        cout << "\n";
        return;
    }
    for (int i = s; i <= N; i++)
    {
        arr[cnt] = i;
        dfs(N, M, cnt + 1, i);
    }
}
int main()
{
    int N, M;
    cin >> N >> M;
    dfs(N, M, 0, 1);
    return 0;
}