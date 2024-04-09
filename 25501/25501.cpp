#include "bits/stdc++.h"
using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    int T;
    int cnt;
    string S;
    cin >> T;
    for (int i = 0; i < T; i++)
    {
        cnt = 1;
        cin >> S;
        int l = 0;
        int r = S.length() - 1;
        for (int i = 0; i < S.length(); i++)
        {
            if (l >= r)
            {
                cout << 1 << " " << cnt << "\n";
                break;
            }
            else if (S[l] != S[r])
            {
                cout << 0 << " " << cnt << "\n";
                break;
            }
            else
            {
                cnt++;
                l++;
                r--;
            }
        }
    }
    return 0;
}