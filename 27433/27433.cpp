#include "bits/stdc++.h"

using namespace std;

long long Facotrial(long long n)
{
    if (n == 0)
        return 1;
    else
        return n * Facotrial(n - 1);
}

int main()
{
    long long N;
    cin >> N;
    cout << Facotrial(N);
    return 0;
}