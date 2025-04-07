#include <bits/stdc++.h>
using namespace std;
int N, ret = 0;
vector<vector<int>> triangle, dp;
int main()
{
    cin >> N;
    triangle.resize(N + 1, vector<int>(N + 1, 0));
    dp.resize(N + 1, vector<int>(N + 1, 0));
    for (int i = 1; i <= N; i++)
    {
        for (int j = 1; j <= i; j++)
        {
            cin >> triangle[i][j];
        }
    }
    dp[1][1] = triangle[1][1];
    for (int i = 1; i <= N; i++)
    {
        for (int j = 1; j <= i; j++)
        {
            int tmp = dp[i - 1][j] < dp[i - 1][j - 1] ? dp[i - 1][j - 1] : dp[i - 1][j];
            dp[i][j] = tmp + triangle[i][j];
        }
    }
    for (int i = 1; i <= N; i++)
    {
        ret = ret < dp[N][i] ? dp[N][i] : ret;
    }
    cout << ret;
    return 0;
}