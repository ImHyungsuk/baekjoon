#include <iostream>

using namespace std;

void Find(int (*G)[50], int x, int y, int M, int N)
{
    // x좌표는 0이상 N미만, y좌표는 0이상 N 미만이어야 함
    if (x >= 0 && x < M && y >= 0 && y < N)
    {
        // 재귀함수를 이용해서 4개 방향을 하나씩 탐색함
        if (G[x][y] == 1)
        {
            // 한번 탐색한 곳은 cnt에 반영되므로 0으로 바꿈
            G[x][y] = 0;
            // 4개 방향 탐색하여 인접한 좌표는 모두 0으로 바꿈
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
        // 배추밭 초기화
        for (int j = 0; j < 50; j++)
        {
            for (int k = 0; k < 50; k++)
            {
                G[j][k] = 0;
            }
        }
        // 배추 입력
        cin >> M >> N >> K;
        for (int j = 0; j < K; j++)
        {
            cin >> X >> Y;
            G[X][Y] = 1;
        }
        // cnt는 지렁이 수
        cnt = 0;
        // Find 재귀함수로 사용
        // 배추밭 (0,0)부터 차례대로 탐색
        // 만약 배추가 심어져 있으면 cnt++ 후 Find함수
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