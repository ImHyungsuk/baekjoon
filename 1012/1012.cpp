#include <iostream>

using namespace std;

void Find(int (*G)[50], int x, int y, int M, int N)
{
    if (x >= 0 && x < M && y >= 0 && y < N)
    {
        if (G[x][y] == 1)
        {
            G[x][y] = 0;
            Find(G, x + 1, y, M, N);
            Find(G, x, y + 1, M, N);
            Find(G, x - 1, y, M, N);
            Find(G, x, y - 1, M, N);
        }
    }
    else
        return;
}

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    int T, M, N, K;
    int X, Y, cnt;
    int G[50][50];
    cin >> T;
    for (int i = 0; i < T; i++)
    {
        for (int j = 0; j < 50; j++)
        {
            for (int k = 0; k < 50; k++)
            {
                G[j][k] = 0;
            }
        }
        cin >> M >> N >> K;
        for (int j = 0; j < K; j++)
        {
            cin >> X >> Y;
            G[X][Y] = 1;
        }
        cnt = 0;
        for (int j = 0; j < M; j++)
        {
            for (int k = 0; k < N; k++)
            {
                if (G[j][k] == 1)
                {
                    cnt++;
                    Find(G, j, k, M, N);
                }
            }
        }
        cout << cnt << '\n';
    }
    return 0;
}