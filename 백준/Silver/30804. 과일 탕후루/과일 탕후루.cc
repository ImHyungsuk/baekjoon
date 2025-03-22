#include <bits/stdc++.h>
using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    int N, tmp1, cate = 0, total = 0;
    cin >> N;
    vector<int> cnt(N, 0);
    queue<int> q;
    for (int i = 0; i < N; i++)
    {
        cin >> tmp1;
        q.push(tmp1);
        if (cnt[tmp1 - 1] == 0)
            cate++;
        cnt[tmp1 - 1]++;
        while (cate > 2)
        {
            int tmp2 = q.front();
            q.pop();
            cnt[tmp2 - 1]--;
            cate = cnt[tmp2 - 1] == 0 ? cate - 1 : cate;
        }
        total = total > q.size() ? total : q.size();
    }
    cout << total;
    return 0;
}