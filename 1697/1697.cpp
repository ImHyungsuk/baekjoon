#include <iostream>
#include <queue>

using namespace std;

void bfs(int *D, int N, int K, int cnt)
{
    queue<int> q;
    int tmp;
    q.push(N);
    while (!q.empty())
    {
        // 이런 방식은 왜 segfault인지 모르겠음
        // while (q.front() < 0 || q.front() > 100000)
        //     q.pop();
        tmp = q.front();
        q.pop();
        // cout << tmp << '\n';
        if (tmp == K)
            break;
        if (2 * tmp >= 0 && 2 * tmp <= 100000)
        {
            if (2 * tmp != N && D[2 * tmp] == 0)
            {
                q.push(2 * tmp);
                D[2 * tmp] = D[tmp] + 1;
            }
        }
        if (tmp + 1 >= 0 && tmp + 1 <= 100000)
        {
            if (tmp + 1 != N && D[tmp + 1] == 0)
            {
                q.push(tmp + 1);
                D[tmp + 1] = D[tmp] + 1;
            }
        }
        if (tmp - 1 >= 0 && tmp - 1 <= 100000)
        {
            if (tmp - 1 != N && D[tmp - 1] == 0)
            {
                q.push(tmp - 1);
                D[tmp - 1] = D[tmp] + 1;
            }
        }
    }
    return;
}

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    int N, K, tmp, cnt;
    int D[100001] = {
        0,
    };
    cin >> N >> K;
    if (N >= K)
    {
        cout << N - K;
        return 0;
    }
    cnt = 0;
    D[N] = 0;
    bfs(D, N, K, cnt);
    cout << D[K];
    return 0;
}