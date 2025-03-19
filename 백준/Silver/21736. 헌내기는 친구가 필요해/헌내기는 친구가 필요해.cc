#include <bits/stdc++.h>
using namespace std;

int main()
{
    int N, M, cnt = 0, visited[601][601] = {
                           0,
                       };
    int x_n[4] = {-1, 1, 0, 0}, y_n[4] = {0, 0, 1, -1};
    queue<pair<int, int>> q;
    cin >> N >> M;
    vector<vector<char>> v(N, vector<char>(M));
    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < M; j++)
        {
            cin >> v[i][j];
            if (v[i][j] == 'I')
                q.push(make_pair(i, j));
        }
    }
    while (!q.empty())
    {
        int x = q.front().first;
        int y = q.front().second;
        q.pop();
        // cout << "x = " << x << " y = " << y << "\n";
        for (int i = 0; i < 4; i++)
        {
            if (x + x_n[i] >= 0 && x + x_n[i] < N && y + y_n[i] >= 0 && y + y_n[i] < M && visited[x + x_n[i]][y + y_n[i]] == 0)
            {
                if (v[x + x_n[i]][y + y_n[i]] == 'X')
                    continue;
                else
                {
                    if (v[x + x_n[i]][y + y_n[i]] == 'P')
                        cnt++;
                    visited[x + x_n[i]][y + y_n[i]] = 1;
                    q.push(make_pair(x + x_n[i], y + y_n[i]));
                }
            }
        }
    }
    if (cnt == 0)
        cout << "TT";
    else
        cout << cnt;
    return 0;
}