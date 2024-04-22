#include "bits/stdc++.h"
using namespace std;

// 28%쯤에서 틀림

int arr[9][9];
// int visited[9][9] = {
//     0,
// };
vector<pair<int, int>> v;
int f = 0;

int check(int tmp, int x, int y)
{
    int tmpx, tmpy;
    for (int i = 0; i < 9; i++)
    {
        if (tmp == arr[x][i] || tmp == arr[i][y])
            return 0;
    }
    tmpx = x / 3;
    tmpy = y / 3;
    for (int i = 0; i < 3; i++)
    {
        for (int j = 0; j < 3; j++)
        {
            if (tmp == arr[tmpx * 3 + i][tmpy * 3 + j])
                return 0;
        }
    }
    return 1;
}

void dfs(int x, int y, int idx, int cnt)
{
    if (x == 9 && y == 9)
    {
        for (int i = 0; i < 9; i++)
        {
            for (int j = 0; j < 9; j++)
                cout << arr[i][j] << " ";
            cout << "\n";
        }
        f = 1;
        return;
    }
    for (int i = 0; i < 9; i++)
    {
        if (f)
            return;
        if (check(i + 1, x, y))
        {
            idx++;
            arr[x][y] = i + 1;
            if (idx < cnt)
                dfs(v[idx].first, v[idx].second, idx, cnt);
            else
                dfs(9, 9, idx, cnt);
            idx--;
            arr[x][y] = 0;
        }
    }
    return;
}

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    int cnt = 0;
    for (int i = 0; i < 9; i++)
    {
        for (int j = 0; j < 9; j++)
        {
            cin >> arr[i][j];
            if (arr[i][j] == 0)
            {
                v.push_back({i, j});
                cnt++;
            }
            // else
            //     visited[i][arr[i][j] - 1] = 1;
        }
    }
    dfs(v[0].first, v[0].second, 0, cnt);
    return 0;
}