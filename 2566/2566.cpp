#include <iostream>

using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    int a[9][9];
    int ret = -1, x, y;
    // 배열에 들어가는 수가 0부터 99까지이므로 초기에 -1로 설정
    for (int i = 0; i < 9; i++)
    {
        for (int j = 0; j < 9; j++)
        {
            cin >> a[i][j];
        }
    }
    for (int i = 0; i < 9; i++)
    {
        for (int j = 0; j < 9; j++)
        {
            if (ret < a[i][j])
            {
                ret = a[i][j];
                x = j + 1;
                y = i + 1;
            }
        }
    }
    cout << ret << '\n';
    cout << y << " " << x;
    return 0;
}