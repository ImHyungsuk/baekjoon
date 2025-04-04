#include <bits/stdc++.h>
using namespace std;

long long power(long long a, long long b, long long c)
{
    if (b == 0)
        return 1;
    if (b == 1)
        return a % c;
    long long tmp = power(a, b / 2, c) % c;
    if (b % 2 == 0)
        return tmp * tmp % c;
    return tmp * tmp % c * a % c;
}
int main()
{
    long long A, B, C;
    cin >> A >> B >> C;
    cout << power(A, B, C);
}