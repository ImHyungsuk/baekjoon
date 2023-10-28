#include <iostream>
#include <ctime>

using namespace std;

int main()
{
    int N, tmp = 1, cnt = 0;
    cin >> N;
    while (N)
    {
        tmp = N;
        while (1)
        {
            if (tmp % 5 == 0)
            {
                cnt++;
                tmp /= 5;
            }
            else
            {
                break;
            }
        }
        N--;
    }
    cout << cnt << '\n';

    return 0;
}