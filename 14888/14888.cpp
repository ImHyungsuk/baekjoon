#include "bits/stdc++.h"
using namespace std;

int arr[4], A[100];
int maximum = -100001, minimum = 100001;
// max, min 값은 백준에 제출할 땐 각각 절댓값이 10억1이어야함

void dfs(int N, int s, int ret)
{
    int tmp;
    if (s == N - 1)
    {
        if (ret > maximum)
            maximum = ret;
        if (ret < minimum)
            minimum = ret;
        return;
    }
    for (int i = 0; i < 4; i++)
    {
        if (arr[i] > 0)
        {
            tmp = ret;
            arr[i]--;
            if (i == 0)
                ret = ret + A[s + 1];
            else if (i == 1)
                ret = ret - A[s + 1];
            else if (i == 2)
                ret = ret * A[s + 1];
            else if (i == 3)
                ret = ret / A[s + 1];
            dfs(N, s + 1, ret);
            ret = tmp;
            arr[i]++;
        }
    }
    return;
}

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    int N;
    cin >> N;
    for (int i = 0; i < N; i++)
        cin >> A[i];
    for (int i = 0; i < 4; i++)
        cin >> arr[i];
    dfs(N, 0, A[0]);
    cout << maximum << "\n"
         << minimum;
    return 0;
}