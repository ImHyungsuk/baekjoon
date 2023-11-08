#include <iostream>
#include <queue>

using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    int N, r, c;
    int tmp;
    queue<int> q;
    cin >> N >> r >> c;
    // tmp = 2^N을 만들기
    tmp = 1;
    for (int i = 0; i < N; i++)
        tmp *= 2;
    // 좌표값이라 (0,0)부터 시작하지만
    // 계산의 편의를 위해 좌표값에 1씩 더하기
    r++;
    c++;
    // 2^(N-1)개 행 or 열씩 나누면 큰 판이 4등분 됨
    // 0 1
    // 2 3
    // 4등분 된 구역을 위와 같은 가중치를 두고
    // 특정 좌표가 위차한 것이 어느 구역인지
    // tmp를 계속 절반으로 나눠주면서 구하고 큐에 푸시
    for (int i = 0; i < N; i++)
    {
        tmp /= 2;
        if (r <= tmp && c <= tmp)
        {
            q.push(0);
        }
        else if (r <= tmp && c > tmp)
        {
            q.push(1);
            c -= tmp;
        }
        else if (r > tmp && c <= tmp)
        {
            q.push(2);
            r -= tmp;
        }
        else
        {
            q.push(3);
            c -= tmp;
            r -= tmp;
        }
    }
    tmp = 0;
    // 푸시해둔 가중치를 푸시한 순서대로 더하면서 4를 곱함
    while (!q.empty())
    {
        tmp *= 4;
        tmp += q.front();
        q.pop();
    }
    cout << tmp;
    return 0;
}