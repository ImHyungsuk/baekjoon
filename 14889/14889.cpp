#include "bits/stdc++.h"
using namespace std;
int S[20][20];
int visited[20] = {
    0,
},
    a[20];
long long int minimum = 2000000;

long long int count(int size)
{
    long long int ret1 = 0, ret2 = 0;
    for (int i = 0; i < size - 1; i++)
    {
        for (int j = i + 1; j < size; j++)
        {
            ret1 += S[a[i]][a[j]] + S[a[j]][a[i]];
            ret2 += S[a[i + size]][a[j + size]] + S[a[j + size]][a[i + size]];
        }
    }
    return ret1 > ret2 ? ret1 - ret2 : ret2 - ret1;
}

void dfs(int size, int cnt, int s)
{
    if (cnt == size / 2)
    {
        int j = 0, k = size / 2;
        for (int i = 0; i < size; i++)
        {
            if (visited[i] == 1)
                a[j++] = i;
            else
                a[k++] = i;
        }
        int tmp = count(size / 2);
        if (minimum > tmp)
        {
            minimum = tmp;
            // for (int i = 0; i < size; i++)
            // {
            //     cout << a[i] << " ";
            // }
            // cout << "\n";
        }
        return;
    }

    for (int i = s; i < size; i++)
    {
        if (visited[i] == 0)
        {
            visited[i] = 1;
            dfs(size, cnt + 1, i + 1);
            visited[i] = 0;
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
    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < N; j++)
            cin >> S[i][j];
    }
    dfs(N, 0, 0);
    cout << minimum;
    return 0;
}