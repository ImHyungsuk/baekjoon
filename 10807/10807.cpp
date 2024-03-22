#include <iostream>

using namespace std;

int main()
{
    int N, v, cnt = 0;
    int a[100];
    cin >> N;
    for (int i = 0; i < N; i++)
    {
        cin >> a[i];
    }
    cin >> v;
    for (int i = 0; i < N; i++)
    {
        if (v == a[i])
            cnt++;
    }
    cout << cnt;
    return 0;
}