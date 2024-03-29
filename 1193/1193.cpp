#include <iostream>

using namespace std;

int main()
{
    int N, cnt = 1, i = 0;
    cin >> N;
    while (cnt + i <= N)
    {
        cnt = cnt + i;
        i++;
    }
    if (i % 2 == 0)
        cout << N - cnt + 1 << "/" << i - (N - cnt);
    else
        cout << i - (N - cnt) << "/" << N - cnt + 1;
    return 0;
}