#include <iostream>

using namespace std;

int main()
{
    int N, tmp5, tmp3, cnt;
    cin >> N;
    tmp5 = N / 5;
    while (tmp5 != -1)
    {
        cnt = N - 5 * tmp5;
        if (cnt % 3 == 0)
        {
            tmp3 = cnt / 3;
            break;
        }
        tmp5--;
    }
    if (tmp5 == -1)
        cout << "-1";
    else
        cout << tmp5 + tmp3;

    return 0;
}