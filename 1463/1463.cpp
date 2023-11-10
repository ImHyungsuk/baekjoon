#include <iostream>

using namespace std;

int main()
{
    // 처음으로 접한 동적 프로그래밍
    // Dynamic programming
    // dp[i] 배열을 통해 연산횟수를 점차 더해가는 방식
    // X=10인 경우
    // 1은 그대로니까 => 0
    // 3은 1로 만드려면 3/1 => 1
    // 9는 3으로 만드려면 9/3 => 1+1 = 2
    // 10은 9로 만드려면 10-1 => 2+1 = 3
    // 이런식으로 큰 문제를 작은 문제로 나누어 생각
    ios::sync_with_stdio(false);
    cin.tie(0);
    int X;
    int dp[1000001];
    cin >> X;
    dp[0] = 0;
    dp[1] = 0;
    dp[2] = 1;
    dp[3] = 1;
    for (int i = 4; i <= X; i++)
    {
        dp[i] = dp[i - 1] + 1;
        if (i % 2 == 0 && dp[i] > dp[i / 2] + 1)
            dp[i] = dp[i / 2] + 1;
        if (i % 3 == 0 && dp[i] > dp[i / 3] + 1)
            dp[i] = dp[i / 3] + 1;
    }
    cout << dp[X];
    return 0;
}