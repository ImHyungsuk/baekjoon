#include <bits/stdc++.h>
using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    int N, M, idx = 0, cnt = 0, ret = 0;
    string str, tmp;
    cin >> N >> M >> str;
    while (idx < M)
    {
        if (str[idx] == 'I')
        {
            if (idx + 2 < M && str[idx + 1] == 'O' && str[idx + 2] == 'I')
            {
                cnt += 2;
                idx += 2;
            }
            else
            {
                if (cnt >= 2 * N)
                    ret += (cnt - 2 * N) / 2 + 1;
                cnt = 0;
                idx++;
            }
        }
        else
            idx++;
    }

    cout << ret;
    return 0;
}