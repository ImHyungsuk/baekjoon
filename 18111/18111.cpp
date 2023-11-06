#include <iostream>

using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    int B, N, M, max = 0, tmp = 0, inv = 0, flag;
    int height[501][501], ret[2] = {214748364, 0};
    cin >> N >> M >> B;
    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < M; j++)
        {
            cin >> height[i][j];
            if (height[i][j] > max)
                max = height[i][j];
        }
    }
    int h = 0;
    while (h < max + 1)
    {
        flag = 1;
        tmp = 0;
        inv = 0;
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < M; j++)
            {
                // tmp는 깔아야 할 블럭수
                // inv는 제거해서 인벤토리에 넣는 블럭수
                if (h - height[i][j] > 0)
                    tmp += h - height[i][j];
                else
                    inv += height[i][j] - h;
            }
        }
        if (tmp <= inv + B && ret[0] >= tmp + inv * 2)
        {
            // cout << ret[0] << " " << tmp + inv * 2 << '\n';
            ret[0] = tmp + inv * 2;
            ret[1] = h;
            // cout << "change " << ret[1] << '\n';
        }
        h++;
    }
    cout << ret[0] << " " << ret[1];
    return 0;
}