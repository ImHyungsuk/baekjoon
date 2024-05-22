#include <bits/stdc++.h>
using namespace std;

int N, M;
int cnt = 0;
int arr[100][100];
queue<pair<pair<int, int>, int>> q;

void bfs(int depth)
{
    int x, y;
    while (!q.empty())
    {
        x = q.front().first.first;
        y = q.front().first.second;
        depth = q.front().second;
        // cout << "(x,y,depth) = " << x << "," << y << "," << depth << "\n";
        q.pop();
        if (x - 1 >= 0 && arr[x - 1][y] == 0)
        {
            // cout << "(x,y,arr[x-1][y]) = " << x - 1 << "," << y << "," << arr[x - 1][y] << "\n";
            arr[x - 1][y] = 1;
            q.push({{x - 1, y}, depth + 1});
            cnt--;
        }
        if (x + 1 < M && arr[x + 1][y] == 0)
        {
            // cout << "(x,y,arr[x + 1][y]) = " << x + 1 << "," << y << "," << arr[x + 1][y] << "\n";
            arr[x + 1][y] = 1;
            q.push({{x + 1, y}, depth + 1});
            cnt--;
        }
        if (y - 1 >= 0 && arr[x][y - 1] == 0)
        {
            // cout << "(x,y,arr[x][y-1]) = " << x << "," << y - 1 << "," << arr[x][y - 1] << "\n";
            arr[x][y - 1] = 1;
            q.push({{x, y - 1}, depth + 1});
            cnt--;
        }
        if (y + 1 < N && arr[x][y + 1] == 0)
        {
            // cout << "(x,y,arr[x][y+1]) = " << x << "," << y + 1 << "," << arr[x][y + 1] << "\n";
            arr[x][y + 1] = 1;
            q.push({{x, y + 1}, depth + 1});
            cnt--;
        }
    }
    // cout << "cnt = " << cnt << "\n";
    if (cnt != 0)
    {
        cout << -1;
        return;
    }
    else
    {
        cout << depth;
        return;
    }
}

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    int depth = 0;
    cin >> M >> N;
    cnt = M * N;
    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < M; j++)
        {
            cin >> arr[j][i];
            if (arr[j][i] == 1)
            {
                cnt--;
                q.push({{j, i}, depth});
            }
            else if (arr[j][i] == -1)
                cnt--;
        }
    }
    // for (int i = 0; i < N; i++)
    // {
    //     for (int j = 0; j < M; j++)
    //     {
    //         cout << arr[j][i] << " ";
    //     }
    //     cout << "\n";
    // }
    // cout << "cnt = " << cnt << "\n";
    bfs(depth);
    return 0;
}