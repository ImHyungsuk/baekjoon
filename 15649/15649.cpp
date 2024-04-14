#include "bits/stdc++.h"
using namespace std;

int arr[9] = {
    0,
};
void printNum(int N, int M)
{
    for (int i = 1; i < M + 1; i++)
    {
        for (int j = 1; j <= N; j++)
        {
            if (arr[j] == i)
                cout << j << " ";
        }
    }
    cout << "\n";
    return;
}
void num(int N, int M, int cnt)
{
    for (int i = 1; i <= N; i++)
    {
        if (arr[i] == 0)
        {
            cnt++;
            arr[i] = cnt;
        }
        else
            continue;
        if (cnt == M)
        {
            printNum(N, M);
            arr[i] = 0;
            if (i == N)
                return;
        }
        else
            num(N, M, cnt);
        arr[i] = 0;
        cnt--;
    }
}

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    int N, M;
    int arr[9];
    cin >> N >> M;
    num(N, M, 0);
    return 0;
}