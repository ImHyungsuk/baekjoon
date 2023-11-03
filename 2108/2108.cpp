#include <iostream>
#include <algorithm>

using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    int N, ret, max, cnt;
    int sum = 0;
    int num[500001];
    cin >> N;
    for (int i = 0; i < N; i++)
    {
        cin >> num[i];
        sum = sum + num[i]; // 산술평균 합
    }
    // 합이 양수일 경우
    if (sum >= 0)
    {
        // 모듈러 연산해서 나온 값이 N/2 보다 크면
        // 소수부분이 0.5보다 큼
        if (sum % N <= N / 2)
        {
            ret = sum / N;
            cout << ret << '\n';
        }
        else
        {
            ret = sum / N + 1;
            cout << ret << '\n';
        }
    }
    // 합이 음수
    else
    {
        // 합에 -1 곱하고 양수일 경우과 같이 연산
        // 후 다시 평균에 -1 곱하기
        sum *= -1;
        if (sum % N <= N / 2)
        {
            ret = sum / N;
            ret *= -1;
            cout << ret << '\n';
        }
        else
        {
            ret = sum / N + 1;
            ret *= -1;
            cout << ret << '\n';
        }
    }
    // 오름차순 정렬
    sort(num, num + N);
    // 중앙값
    cout << num[N / 2] << '\n';
    ret = 0;
    sum = 0;
    max = 0;
    cnt = 0;
    // 최빈값
    for (int i = 0; i < N - 1; i++)
    {
        cnt++;
        // 다음 인덱스에서 숫자가 바뀔 경우
        if (num[i] != num[i + 1])
        {
            // 현재값이 최빈값이면
            if (max < cnt)
            {
                // sum 값은 현재 최빈값 중
                // 두 번째로 작은 수인지 판단 위함
                max = cnt;
                ret = num[i];
                cnt = 0;
                sum = 1;
            }
            // 최빈값 여러 개인 경우
            else if (max == cnt)
            {
                max = cnt;
                // 현재 수가 최빈값중
                // 첫번째 혹은 두번째로 작은수일 경우
                if (sum < 2)
                {
                    ret = num[i];
                }
                cnt = 0;
                sum++;
            }
            // 최빈값 아닐 경우 카운트 초기화
            else
            {
                cnt = 0;
            }
        }
    }
    // 최빈값 마지막 인덱스
    cnt++;
    if (max < cnt)
    {
        max = cnt;
        ret = num[N - 1];
        cnt = 0;
        sum = 1;
    }
    else if (max == cnt)
    {
        max = cnt;
        if (sum < 2)
        {
            ret = num[N - 1];
        }
        cnt = 0;
        sum++;
    }
    cout << ret << '\n';
    cout << num[N - 1] - num[0];

    return 0;
}