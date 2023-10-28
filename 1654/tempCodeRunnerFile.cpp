#include <iostream>
#include <ctime>

using namespace std;

int BinarySearch(int s, int e, int *tmp, int K, int N)
{
    if (s > e)
        return 0;
    int mid = (s + e) / 2;
    int cnt = 0;
    int ret;
    for (int i = 0; i < K; i++)
        cnt += tmp[i] / mid;
    if (cnt >= N)
    {
        int a = BinarySearch(mid + 1, e, tmp, K, N);
        if (a)
            return a;
        // cout << mid << '\n';
        return mid;
    }
    else if (cnt < N)
    {
        return BinarySearch(s, mid - 1, tmp, K, N);
    }
    else
    {
        return 0;
    }
}

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    // clock_t start, finish;
    double duration;
    int K, N, cnt;
    int tmp[10001], max = 0, ret;
    cin >> K >> N;
    for (int i = 0; i < K; i++)
    {
        cin >> tmp[i];
        if (tmp[i] > max)
            max = tmp[i];
    }
    // start = clock();
    ret = BinarySearch(1, max, tmp, K, N);
    cout << ret;
    // finish = clock();
    // duration = (double)(finish - start) / CLOCKS_PER_SEC;
    // cout << duration << "secs" << endl;

    return 0;
}