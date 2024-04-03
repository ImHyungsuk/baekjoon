#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main()
{
    int A, n;
    vector<int> v;
    long long int N;
    cin >> A;
    for (int i = 0; i < A; i++)
    {
        cin >> n;
        v.push_back(n);
    }
    sort(v.begin(), v.end());
    if (A % 2 == 0)
        cout << v[A / 2] * v[A / 2 - 1];
    else
        cout << v[A / 2] * v[A / 2];
    return 0;
}