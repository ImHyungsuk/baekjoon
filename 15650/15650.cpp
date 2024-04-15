#include "bits/stdc++.h"
using namespace std;

int a[9] = {
    0,
};
int visit[9] = {
    0,
};

void dfs(int N, int M, int s, int cnt)
{
    if (cnt == M)
    {
        for (int i = 0; i < M; i++)
            cout << a[i] << " ";
        cout << "\n";
        return;
    }
    for (int i = s; i <= N; i++)
    {
        if (::visit[i] == 0)
        {
            ::visit[i] = 1;
            a[cnt] = i;
            dfs(N, M, i + 1, cnt + 1);
            ::visit[i] = 0;
        }
    }
}

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    int N, M;
    cin >> N >> M;
    dfs(N, M, 1, 0);
    return 0;
}