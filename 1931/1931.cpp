#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

bool cmp(const pair<int, int> &a, const pair<int, int> &b)
{
    if (a.second == b.second)
        return a.first < b.first;
    return a.second < b.second;
}

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    int N, s, e, cnt = 0;
    vector<pair<int, int>> v;
    cin >> N;
    for (int i = 0; i < N; i++)
    {
        cin >> s >> e;
        v.push_back(make_pair(s, e));
    }
    sort(v.begin(), v.end(), cmp);
    e = 0;
    // for (int i = 0; i < N; i++)
    // {
    //     cout << v[i].first << ' ' << v[i].second << '\n';
    // }
    for (int i = 0; i < N; i++)
    {
        if (e <= v[i].first)
        {
            cnt++;
            e = v[i].second;
        }
    }

    cout << cnt;
    // while (!q.empty())
    // {
    //     q.pop();
    //     flag++;
    // }
    // cout << flag;
    return 0;
}