#include <bits/stdc++.h>
using namespace std;
int visited[1001][1001] = {
    0,
};
int main()
{
    int n, m, tmp;
    cin >> n >> m;
    vector<vector<int>> v(n, vector<int>(m));
    queue<pair<pair<int, int>, int>> q;
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m; j++)
        {
            cin >> tmp;
            v[i][j] = tmp;
            if (tmp == 2)
            {
                q.push(make_pair(make_pair(i, j), 0));
                visited[i][j] = 1;
            }
        }
    }
    while (!q.empty())
    {
        int x = q.front().first.first;
        int y = q.front().first.second;
        int dis = q.front().second;
        // cout << x << " " << y << "\n";
        v[x][y] = dis;
        q.pop();
        if (x - 1 >= 0 && visited[x - 1][y] == 0 && v[x - 1][y] != 0)
        {
            visited[x - 1][y] = 1;
            q.push(make_pair(make_pair(x - 1, y), dis + 1));
        }
        if (x + 1 < n && visited[x + 1][y] == 0 && v[x + 1][y] != 0)
        {
            visited[x + 1][y] = 1;
            q.push(make_pair(make_pair(x + 1, y), dis + 1));
        }
        if (y - 1 >= 0 && visited[x][y - 1] == 0 && v[x][y - 1] != 0)
        {
            visited[x][y - 1] = 1;
            q.push(make_pair(make_pair(x, y - 1), dis + 1));
        }
        if (y + 1 < m && visited[x][y + 1] == 0 && v[x][y + 1] != 0)
        {
            visited[x][y + 1] = 1;
            q.push(make_pair(make_pair(x, y + 1), dis + 1));
        }
    }
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m; j++)
        {
            if (v[i][j] == 1 && visited[i][j] == 0)
                cout << -1 << " ";
            else
                cout << v[i][j] << " ";
        }
        cout << "\n";
    }
    return 0;
}