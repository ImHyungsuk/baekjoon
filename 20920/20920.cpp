#include "bits/stdc++.h"

using namespace std;

map<string, int> m;
bool cmp(string a, string b)
{
    if (a.size() == b.size() && m[a] == m[b])
        return a < b;
    else if (m[a] == m[b])
        return a.size() > b.size();
    else
        return m[a] > m[b];
}

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    int N, M, cnt;
    string a;
    vector<string> v;
    cin >> N >> M;
    for (int i = 0; i < N; i++)
    {
        cin >> a;
        if (a.size() < M)
            continue;
        if (m.find(a) == m.end())
        {
            m.insert({a, 1});
            v.push_back(a);
        }
        else
        {
            m[a]++;
        }
    }
    sort(v.begin(), v.end(), cmp);
    for (int i = 0; i < v.size(); i++)
        cout << v[i] << "\n";
    return 0;
}