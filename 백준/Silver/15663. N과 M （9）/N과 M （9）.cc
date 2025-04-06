#include <bits/stdc++.h>
using namespace std;
vector<int> num, num_cnt(10001, 0), ret;

void back_track(int M, int cnt)
{
    if (cnt == M)
    {
        for (int i = 0; i < M; i++)
        {
            cout << ret[i] << " ";
        }
        cout << "\n";
    }
    else
    {
        for (size_t i = 0; i < num.size(); i++)
        {
            if (num_cnt[num[i]] == 0)
            {
                continue;
            }
            ret.push_back(num[i]);
            num_cnt[num[i]]--;
            back_track(M, cnt + 1);
            num_cnt[num[i]]++;
            ret.erase(ret.begin() + cnt);
        }
    }
}

int main()
{
    int N, M, input;
    cin >> N >> M;
    for (int i = 0; i < N; i++)
    {
        cin >> input;
        if (num_cnt[input] == 0)
            num.push_back(input);
        num_cnt[input]++;
    }
    sort(num.begin(), num.end());
    back_track(M, 0);
    return 0;
}