#include <iostream>
#include <queue>

using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    int T, N, M, tmp, ret;
    int imp[101], cnt[10];
    queue<pair<int, int>> pr;
    cin >> T;
    for (int i = 0; i < T; i++)
    {
        tmp = 0;
        cin >> N >> M;
        for (int j = 0; j < 10; j++)
        {
            cnt[j] = 0;
        }
        for (int j = 0; j < N; j++)
        {
            cin >> imp[j];
            pr.push(make_pair(j, imp[j]));
            cnt[imp[j]]++;
        }
        for (int l = 9; l > 0; l--)
        {
            while (cnt[l] > 0)
            {
                if (pr.front().second == l)
                {
                    if (pr.front().first == M)
                        ret = tmp;
                    pr.pop();
                    cnt[l]--;
                    tmp++;
                }
                else
                {
                    pr.push(make_pair(pr.front().first, pr.front().second));
                    pr.pop();
                }
            }
        }
        cout << ret + 1 << '\n';
    }
    return 0;
}