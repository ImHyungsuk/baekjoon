#include <iostream>

using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    int T, N;
    int one[2] = {0, 1}, zero[2] = {1, 0}, tmp;
    cin >> T;
    for (int i = 0; i < T; i++)
    {
        cin >> N;
        zero[0] = 1;
        zero[1] = 0;
        one[0] = 0;
        one[1] = 1;
        for (int j = 1; j < N; j++)
        {
            tmp = zero[1];
            zero[1] = zero[0] + zero[1];
            zero[0] = tmp;
            tmp = one[1];
            one[1] = one[0] + one[1];
            one[0] = tmp;
        }
        if (N == 0)
            cout << zero[0] << ' ' << one[0] << '\n';
        else if (N == 1)
            cout << zero[1] << ' ' << one[1] << '\n';
        else
            cout << zero[1] << ' ' << one[1] << '\n';
    }
    return 0;
}