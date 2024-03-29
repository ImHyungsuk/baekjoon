#include <iostream>

using namespace std;

int main()
{
    int N, x, y, cnt = 0;
    int p[100][100] = {
        0,
    };
    cin >> N;
    for (int i = 0; i < N; i++)
    {
        cin >> x >> y;
        for (int j = x; j < x + 10; j++)
        {
            for (int k = y; k < y + 10; k++)
            {
                if (p[k][j] == 0)
                {
                    p[k][j] = 1;
                    cnt++;
                }
            }
        }
    }
    cout << cnt;
    return 0;
}