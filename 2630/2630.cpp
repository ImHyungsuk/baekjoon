#include "bits/stdc++.h"
using namespace std;

int paper[128][128];
int N;
int w, b;

void bluewhite(int N, int x, int y)
{
    int curr = paper[y][x];
    for (int i = y; i < y + N; i++)
    {
        for (int j = x; j < x + N; j++)
        {
            if (paper[i][j] != curr)
            {
                bluewhite(N / 2, x, y);
                bluewhite(N / 2, x + N / 2, y);
                bluewhite(N / 2, x, y + N / 2);
                bluewhite(N / 2, x + N / 2, y + N / 2);
                return;
            }
        }
    }
    if (curr == 1)
        b++;
    else
        w++;
}

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> N;
    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < N; j++)
        {
            cin >> paper[i][j];
        }
    }
    bluewhite(N, 0, 0);
    cout << w << "\n"
         << b;
    return 0;
}