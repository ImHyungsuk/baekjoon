#include <bits/stdc++.h>
using namespace std;

int main()
{
    int N, min = 1001;
    vector<vector<int>> v, dp;
    cin >> N;
    v.resize(N + 1, vector<int>(3, 0));
    dp.resize(N + 1, vector<int>(3, 0));
    for (int i = 1; i <= N; i++)
    {
        for (int j = 0; j < 3; j++)
        {
            cin >> v[i][j];
        }
    }
    for (int i = 1; i <= N; i++)
    {
        dp[i][0] = (dp[i - 1][1] < dp[i - 1][2] ? dp[i - 1][1] : dp[i - 1][2]) + v[i][0];
        dp[i][1] = (dp[i - 1][0] < dp[i - 1][2] ? dp[i - 1][0] : dp[i - 1][2]) + v[i][1];
        dp[i][2] = (dp[i - 1][1] < dp[i - 1][0] ? dp[i - 1][1] : dp[i - 1][0]) + v[i][2];
    }

    min = dp[N][1] > dp[N][0] ? dp[N][0] : dp[N][1];
    min = dp[N][2] < min ? dp[N][2] : min;
    cout << min;
    return 0;
}