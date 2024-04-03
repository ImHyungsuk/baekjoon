#include <iostream>

using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    int T, N, M, tmp1, tmp2, sum;
    cin >> T;
    for (int i = 0; i < T; i++)
    {
        cin >> N >> M;
        sum = 1;
        tmp1 = (N < M - N) ? N : M - N;
        N = 1;
        tmp2 = M;
        for (int j = 0; j < tmp1; j++)
        {
            sum *= M;
            M--;
            sum /= N;
            N++;
        }
        cout << sum << "\n";
    }
    return 0;
}