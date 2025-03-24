#include "bits/stdc++.h"
using namespace std;

int visited[15][15] = {
    0,
};
int ret = 0;

int check(int N, int x, int y)
{
    int i;
    // cout << x << " " << y << " start\n";
    for (i = 1; x - i >= 0; i++)
    {
        if (visited[x - i][y] == 1)
        {
            // cout << x << " " << i << "\n";
            return 0;
        }
        if (y - i >= 0 && visited[x - i][y - i] == 1)
        {
            // cout << x - i << " " << y - i << "\n";
            return 0;
        }
        else if (y + i < N && visited[x - i][y + i] == 1)
        {
            // cout << x - i << " " << y + i << "\n";
            return 0;
        }
    }
    return 1;
}

void Nqueen(int N, int cnt, int x, int y)
{
    if (cnt == N)
    {
        ret++;
        return;
    }
    for (int j = 0; j < N; j++)
    {
        if (visited[x][j] == 0 && check(N, x, j) == 1)
        {
            // cout << i << " " << j << " get\n";
            visited[x][j] = 1;
            Nqueen(N, cnt + 1, x + 1, j);
            visited[x][j] = 0;
        }
    }
    return;
}

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    int N;
    cin >> N;
    Nqueen(N, 0, 0, 0);
    cout << ret;
    return 0;
}