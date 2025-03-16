#include <bits/stdc++.h>
using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    int N, M;
    string site, pwd;
    map<string, string> m;
    cin >> N >> M;
    for (int i = 0; i < N; i++)
    {
        cin >> site >> pwd;
        m.insert(make_pair(site, pwd));
    }
    for (int i = 0; i < M; i++)
    {
        cin >> site;
        cout << m[site] << "\n";
    }
    return 0;
}