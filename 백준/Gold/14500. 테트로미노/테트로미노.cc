#include <bits/stdc++.h>
using namespace std;
int N, M;
int ret = 0;
vector<vector<int>> v(500, vector<int>(500, 0)), m(500, vector<int>(500, 0));
int visited[500][500] = {
    0,
};
int dx[4] = {-1, 1, 0, 0};
int dy[4] = {0, 0, 1, -1};
void dfs(int x, int y, int cnt, int sum)
{
    if (cnt == 4)
        ret = ret < sum ? sum : ret;
    else
    {
        for (int i = 0; i < 4; i++)
        {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx >= M || ny < 0 || ny >= N)
                continue;
            if (visited[nx][ny] == 0)
            {
                visited[nx][ny] = 1;
                dfs(nx, ny, cnt + 1, sum + v[nx][ny]);
                visited[nx][ny] = 0;
            }
        }
    }
}
int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    cin >> N >> M;
    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < M; j++)
            cin >> v[j][i];
    }
    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < M; j++)
        {
            visited[j][i] = 1;
            dfs(j, i, 1, v[j][i]);
            visited[j][i] = 0;
            int tmp;
            if (i - 1 >= 0 && j - 1 >= 0 && j < M)
            {
                tmp = v[j][i] + v[j - 1][i] + v[j + 1][i] + v[j][i - 1];
                ret = ret < tmp ? tmp : ret;
            }
            if (i + 1 < N && j - 1 >= 0 && j < M)
            {
                tmp = v[j][i] + v[j - 1][i] + v[j + 1][i] + v[j][i + 1];
                ret = ret < tmp ? tmp : ret;
            }
            if (i + 1 < N && j - 1 >= 0 && i - 1 >= 0)
            {
                tmp = v[j][i] + v[j][i - 1] + v[j][i + 1] + v[j - 1][i];
                ret = ret < tmp ? tmp : ret;
            }
            if (i + 1 < N && j + 1 < M && i - 1 >= 0)
            {
                tmp = v[j][i] + v[j][i - 1] + v[j][i + 1] + v[j + 1][i];
                ret = ret < tmp ? tmp : ret;
            }
        }
    }
    cout << ret;
    return 0;
}