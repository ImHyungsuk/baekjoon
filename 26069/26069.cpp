#include <bits/stdc++.h>
using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    int N, cnt;
    string a, b;
    map<string, int> m;
    cin >> N;
    cnt = 0;
    for (int i = 0; i < N; i++)
    {
        cin >> a >> b;
        if (cnt == 0 && (a == "ChongChong" || b == "ChongChong"))
        {
            m.insert({a, cnt});
            cnt++;
            m.insert({b, cnt});
            cnt++;
        }
        else if (cnt && m.find(a) != m.end() && m.find(b) == m.end())
        {
            m.insert({b, cnt});
            cnt++;
        }
        else if (cnt && m.find(b) != m.end() && m.find(a) == m.end())
        {
            m.insert({a, cnt});
            cnt++;
        }
    }
    cout << cnt;
    return 0;
}