#include <iostream>

using namespace std;

int main()
{
    int A[3], B[3];
    int big, small, i = 0;
    ;
    for (i = 0; i < 2; i++)
        cin >> A[i] >> B[i];
    if (B[0] > B[1])
    {
        big = B[0];
        small = B[1];
    }
    else
    {
        big = B[1];
        small = B[0];
    }
    i = 1;
    while (1)
    {
        if (big * i % small == 0)
            break;
        i++;
    }
    B[2] = big * i;
    A[2] = A[0] * (big * i / B[0]) + A[1] * (big * i / B[1]);

    for (i = A[2] > B[2] ? B[2] : A[2]; i > 0; i--)
    {
        if (A[2] % i == 0 && B[2] % i == 0)
            break;
    }
    A[2] /= i;
    B[2] /= i;

    cout << A[2] << ' ' << B[2];
    return 0;
}