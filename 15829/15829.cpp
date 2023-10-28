#include <iostream>

using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    int L;
    string tmp;
    long long int ret = 0,r;
    cin >> L;
    cin >> tmp;
    for (int i = 0; i < L; i++)
    {
        // cout << tmp[i] << '\n';
        r = 1;
        for (int j = 0; j < i; j++)
        {
            r *= 31;
            r %= 1234567891;
        }
        ret += ((long long int)tmp[i] - 96) * r;
        ret %= 1234567891;
        // cout << ret << '\n';
    }

    cout << ret;
    return 0;
}