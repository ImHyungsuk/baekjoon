#include <iostream>
#include <algorithm>

using namespace std;

// 위 아래로 각각 제외할 인원 수를 구함
int trimmed_mean(int n)
{
    int per = 30;
    per /= 2;
    n *= per;
    if (n % 100 < 50)
        return n / 100;
    else
        return n / 100 + 1;
}

int main()
{
    int n, except, tmp, ret = 0;
    int level[300001];
    cin >> n;
    if (n == 0)
    {
        cout << 0;
        return 0;
    }
    except = trimmed_mean(n);
    for (int i = 0; i < n; i++)
        cin >> level[i];
    // 투표한 난이도 정렬
    sort(level, level + n);
    n = n - (2 * except);
    // 절사평균 구하기
    for (int i = 0; i < n; i++)
        ret += level[i + except];
    // 반올림
    // n이 홀수일 경우와 짝수일 경우 나눠야함
    if (n % 2 == 0)
    {
        if ((ret % n) < n / 2)
            cout << ret / n;
        else
            cout << ret / n + 1;
    }
    else
    {
        if ((ret % n) <= n / 2)
            cout << ret / n;
        else
            cout << ret / n + 1;
    }
    return 0;
}