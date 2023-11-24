#include <iostream>
#include <queue>

using namespace std;
// bfs를 기본 문제 한문제 밖에 안풀어봐서 오래걸렸음
// 애초에 bfs문제인지도 몰랐고 처음부터 다 생각해냈음

void bacon(int (*fr)[101], int mp, int s, int N)
{
    int tmp, visit[101] = {
                 0,
             };
    queue<int> q;
    q.push(s);
    visit[s] = 1;
    while (!q.empty())
    {
        tmp = q.front();
        q.pop();
        for (int i = 1; i < N + 1; i++)
        {
            if (fr[tmp][i] == 1 && visit[i] == 0)
            {
                q.push(i);
                visit[i] = 1;
                fr[s][i] = fr[s][tmp] + 1;
            }
        }
    }
    return;
}

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    int N, M, tmp1, tmp2 = 101;
    int fr[101][101] = {
        0,
    };
    int node[101] = {
        0,
    };
    cin >> N >> M;
    for (int j = 1; j < N + 1; j++)
    {
        for (int k = 1; k < N + 1; k++)
        {
            if (j == k)
                continue;
            fr[j][k] = 99999;
        }
    }
    for (int i = 0; i < M; i++)
    {
        cin >> tmp1 >> tmp2;
        fr[tmp1][tmp2] = 1;
        fr[tmp2][tmp1] = 1;
    }
    for (int i = 1; i < N + 1; i++)
    {
        bacon(fr, i, i, N);
    }
    // for (int j = 1; j < N + 1; j++)
    // {
    //     for (int k = 1; k < N + 1; k++)
    //     {
    //         cout << fr[j][k] << ' ';
    //     }
    //     cout << '\n';
    // }
    tmp2 = 99999;
    for (int i = 1; i < N + 1; i++)
    {
        for (int j = 1; j < N + 1; j++)
        {
            node[i] += fr[i][j];
        }
        // cout << i << "th: " << node[i] << "\n";
        if (tmp2 > node[i])
        {
            tmp2 = node[i];
            tmp1 = i;
        }
    }
    cout << tmp1;

    return 0;
}