#include <bits/stdc++.h>
using namespace std;

int gcd(int tmp1, int tmp2)
{
    if (tmp2 == 0)
        return tmp1;
    else
        return gcd(tmp2, tmp1 % tmp2);
}
int lcm(int tmp1, int tmp2)
{
    return tmp1 * tmp2 / gcd(tmp1, tmp2);
}

int main()
{
    int T, M, N, x, y, tmp, max;
    cin >> T;
    for (int i = 0; i < T; i++)
    {
        cin >> M >> N >> x >> y;
        max = lcm(M, N);
        tmp = x;
        int result = -1;
        for (int j = x; j <= max; j += M)
        {
            tmp = j % N;
            if (tmp == 0)
                tmp = N;
            if (tmp == y)
            {
                result = j;
                break;
            }
        }
        cout << result << "\n";
    }
    return 0;
}