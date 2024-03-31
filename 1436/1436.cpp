#include <iostream>

using namespace std;

int check(int cnt)
{
    int n = 0;
    while (cnt)
    {
        if (cnt % 10 == 6)
        {
            n++;
            if (n == 3)
                break;
        }
        else
            n = 0;
        cnt /= 10;
    }
    if (n == 3)
        return 1;
    else
        return 0;
}

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    int N, cnt = 0;
    cin >> N;
    while (N)
    {
        cnt++;
        if (check(cnt))
        {
            N--;
            // cout << cnt << '\n';
        }
        // cout << "cnt = " << cnt << '\n';
    }
    cout << cnt;
    return 0;
}