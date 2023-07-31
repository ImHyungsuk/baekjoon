#include <iostream>

using namespace std;

int check_but(int tmp, int *but)
{
    int i;
    i = tmp % 10;
    if (but[i] == 0)
        return 0;
    while (tmp)
    {
        i = tmp % 10;
        if (but[i] == 0)
            return 0;
        tmp /= 10;
    }
    return 1;
}
int get_digit(int n)
{
    int i = 0;
    if (n == 0)
        return 1;
    while (n)
    {
        n /= 10;
        i++;
    }
    return i;
}

int main()
{
    ios::sync_with_stdio(false);
    int N, M, tmp, cnt;
    int but[10] = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    cin >> N;
    cin >> M;
    for (int i = 0; i < M; i++)
    {
        cin >> tmp;
        but[tmp] = 0;
    }
    if (N == 100)
    {
        cout << 0;
        return 0;
    }
    if (M == 10)
    {
        if (N > 100)
        {
            cout << N - 100;
            return 0;
        }
        else
        {
            cout << 100 - N;
            return 0;
        }
    }
    tmp = N;
    while (tmp >= 0 && tmp <= 1000000)
    {
        if (check_but(tmp, but))
            break;
        tmp++;
    }
    if (N > 100)
        cnt = (N - 100 < (tmp - N + get_digit(tmp)) ? N - 100 : (tmp - N + get_digit(tmp)));
    else
        cnt = (100 - N < (tmp - N + get_digit(tmp)) ? 100 - N : (tmp - N + get_digit(tmp)));
    tmp = N;
    while (tmp >= 0 && tmp <= 1000000)
    {
        if (check_but(tmp, but))
            break;
        tmp--;
    }
    if (tmp != -1)
    {
        cnt = (cnt < (N - tmp + get_digit(tmp)) ? cnt : (N - tmp + get_digit(tmp)));
        if (N > 100)
            cnt = (N - 100 < cnt ? N - 100 : cnt);
        else
            cnt = (100 - N < cnt ? 100 - N : cnt);
    }
    cout << cnt;
    return 0;
}
/*
int highcase(int *but, int *digit, int n)
{
    while (n <= 9)
    {
        if (but[n] == 1)
        {
            return n;
        }
        n++;
    }
    return -1;
}
int lowcase(int *but, int *digit, int n)
{
    while (n >= 0)
    {
        if (but[n] == 1)
        {
            return n;
        }
        n--;
    }
    return -1;
}

int main()
{
    int N, M, i, j;
    int but[10] = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, digit[6];
    int tmp[3] = {0, 0, 0}, ret[3] = {1000000, 1000000, 1000000};

    cin >> N;
    cin >> M;
    for (i = 0; i < M; i++)
    {
        cin >> tmp[0];
        but[tmp[0]] = 0;
    }
    if (M == 10)
    {
        if (N >= 100)
        {
            cout << N - 100;
            return 0;
        }
        else
        {
            cout << 100 - N;
            return 0;
        }
    }
    tmp[0] = N;
    i = 0;
    while (tmp[0] != 0)
    {
        digit[i] = tmp[0] % 10;
        i++;
        tmp[0] /= 10;
    }
    i--;
    // cout << i + 1 << "digit\n";
    //   check
    // cout << digit[i] << endl;
    // cout << ret[0] << ret[1] << ret[2] << endl;

    if (but[digit[i]] == 1)
    {
        ret[0] = 0;
        ret[0] = ret[0] * 10 + digit[i];
        // cout << "ret[0] = " << ret[0] << '\n'; // check
        j = i - 1;
        // cout << j << '\n'; // check
        while (j >= 0)
        {
            if (but[digit[j]] == 1)
                ret[0] = ret[0] * 10 + digit[j];
            else
            {
                tmp[1] = lowcase(but, digit, digit[j] - 1);
                tmp[2] = highcase(but, digit, digit[j] + 1);
                tmp[0] = tmp[2] - digit[j] > digit[j] - tmp[1] ? tmp[2] : tmp[1];
                // cout << "tmp = " << tmp[0] << '\n'; // check
                ret[0] = ret[0] * 10 + tmp[0];
            }
            j--;
            cout << ret[0] << '\n'; // check
        }
    }
    cout << "ret[0] = " << ret[0] << '\n'; // check
    tmp[1] = lowcase(but, digit, digit[i] - 1);
    if (tmp[1] >= 0)
    {
        ret[1] = 0;
        ret[1] = ret[1] * 10 + tmp[1];
        tmp[0] = lowcase(but, digit, 9);
        j = i - 1;
        while (j >= 0)
        {
            ret[1] = ret[1] * 10 + tmp[0];
            j--;
        }
    }
    cout << "ret[1] = " << ret[1] << '\n';
    tmp[2] = highcase(but, digit, digit[i] + 1);
    if (tmp[2] >= 0)
    {
        ret[2] = 0;
        ret[2] = ret[2] * 10 + tmp[2];
        tmp[0] = highcase(but, digit, 0);
        j = i - 1;
        while (j >= 0)
        {
            ret[2] = ret[2] * 10 + tmp[0];
            j--;
        }
    }
    cout << "ret[2] = " << ret[2] << '\n';
    for (i = 0; i < 3; i++)
    {
        if (ret[i] > N)
            tmp[i] = ret[i] - N;
        else
            tmp[i] = N - ret[i];
        if (ret[i] == 0)
            tmp[i]++;
        else
        {
            while (ret[i])
            {
                ret[i] /= 10;
                tmp[i]++;
            }
        }
        if (tmp[i] <= tmp[0])
            tmp[0] = tmp[i];
    }
    cout << tmp[0] << '\n';
    if (N > 100)
        cout << ((tmp[0] > (N - 100)) ? (N - 100) : tmp[0]) << '\n';
    else
        cout << ((tmp[0] > (100 - N)) ? (100 - N) : tmp[0]) << '\n';
    return 0;
}
*/