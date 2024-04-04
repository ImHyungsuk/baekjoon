#include <bits/stdc++.h>

using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    int N, cnt, f;
    string a;
    map<string, int> m;
    cnt = 0;
    cin >> N;
    for (int i = 0; i < N; i++)
    {
        cin >> a;
        if (a == "ENTER")
            m.clear();
        else
        {
            if (m.find(a) == m.end())
            {
                cnt++;
                m.insert({a, cnt});
            }
        }
    }
    cout << cnt;
    return 0;
}