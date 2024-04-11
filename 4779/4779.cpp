#include "bits/stdc++.h"
using namespace std;

void cantor(int *a, int N, int s, int e)
{
    if (N == 0)
        return;
    int size = pow(3, N - 1);
    for (int i = s; i < s + size; i++)
        a[i + size] = -1;
    N--;
    cantor(a, N, s, s + size - 1);
    cantor(a, N, e - size + 1, e);
}

int main()
{
    int N;
    int a[50001] = {
        0,
    };
    int size;
    string s;
    while (cin >> N)
    {
        size = pow(3, N);
        cantor(a, N, 0, size - 1);
        for (int i = 0; i < size; i++)
        {
            if (a[i] == -1)
                cout << " ";
            else
                cout << "-";
            a[i] = 0;
        }
        cout << "\n";
    }
    return 0;
}