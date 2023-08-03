#include <iostream>

using namespace std;

int main()
{
    long long int A, B, big, small;
    int i = 1;

    cin >> A >> B;
    if (A > B)
    {
        big = A;
        small = B;
    }
    else
    {
        big = B;
        small = A;
    }
    while (1)
    {
        if (big * i % small == 0)
            break;
        i++;
    }
    cout << big * i;

    return 0;
}