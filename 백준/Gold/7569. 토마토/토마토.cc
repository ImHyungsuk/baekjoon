#include <bits/stdc++.h>
using namespace std;
int M, N, H, sum, cnt;
int arr[100][100][100];
queue<pair<pair<int, int>, int>> q;
void bfs()
{
    int day = 0;
    int x, y, z;
    while (!q.empty())
    {
        x = q.front().first.first;
        y = q.front().first.second;
        z = q.front().second;
        day = arr[x][y][z];
        if (x - 1 >= 0 && arr[x - 1][y][z] == 0)
        {
            q.push(make_pair(make_pair(x - 1, y), z));
            arr[x - 1][y][z] = day + 1;
            cnt++;
        }
        if (x + 1 < M && arr[x + 1][y][z] == 0)
        {
            q.push(make_pair(make_pair(x + 1, y), z));
            arr[x + 1][y][z] = day + 1;
            cnt++;
        }
        if (y - 1 >= 0 && arr[x][y - 1][z] == 0)
        {
            q.push(make_pair(make_pair(x, y - 1), z));
            arr[x][y - 1][z] = day + 1;
            cnt++;
        }
        if (y + 1 < N && arr[x][y + 1][z] == 0)
        {
            q.push(make_pair(make_pair(x, y + 1), z));
            arr[x][y + 1][z] = day + 1;
            cnt++;
        }
        if (z - 1 >= 0 && arr[x][y][z - 1] == 0)
        {
            q.push(make_pair(make_pair(x, y), z - 1));
            arr[x][y][z - 1] = day + 1;
            cnt++;
        }
        if (z + 1 < H && arr[x][y][z + 1] == 0)
        {
            q.push(make_pair(make_pair(x, y), z + 1));
            arr[x][y][z + 1] = day + 1;
            cnt++;
        }
        q.pop();
    }
    if (cnt == sum)
        cout << day - 1;
    else
        cout << -1;
}

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    cin >> M >> N >> H;
    sum = M * N * H;
    cnt = 0;
    for (int k = 0; k < H; k++)
    {
        for (int j = 0; j < N; j++)
        {
            for (int i = 0; i < M; i++)
            {
                cin >> arr[i][j][k];
                if (arr[i][j][k] == 1)
                {
                    q.push(make_pair(make_pair(i, j), k));
                    cnt++;
                }
                else if (arr[i][j][k] == -1)
                {
                    sum--;
                }
            }
        }
    }
    bfs();
    return 0;
}