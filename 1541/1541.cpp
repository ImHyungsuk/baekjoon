#include <iostream>
#include <queue>

using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    string st;
    int i = 0, j = 0, tmp = 0, tmp2 = 0, tmp1;
    char a;
    queue<int> num;
    queue<char> sign;
    long long int ret = 0;
    cin >> st;
    while (st[i] >= '0' && st[i] <= '9')
    {
        tmp2 *= 10;
        tmp2 += st[i] - 48;
        i++;
    }
    // cout << "push " << tmp2 << '\n';
    num.push(tmp2);
    tmp2 = 0;
    while (st[i] != '\0')
    {
        if (st[i] == '+' || st[i] == '-')
        {
            sign.push(st[i]);
            // cout << "push " << st[i] << '\n';
            i++;
        }
        while (st[i] >= '0' && st[i] <= '9')
        {
            tmp2 *= 10;
            tmp2 += st[i] - 48;
            i++;
        }
        // cout << "push " << tmp2 << '\n';
        num.push(tmp2);
        tmp2 = 0;
    }
    tmp1 = num.front();
    num.pop();
    while (!num.empty() && !sign.empty())
    {
        if (sign.front() == '-')
        {
            a = sign.front();
            sign.pop();
            tmp2 = num.front();
            num.pop();
            while (sign.front() == '+' && !sign.empty())
            {
                tmp2 += num.front();
                num.pop();
                sign.pop();
            }
            tmp1 -= tmp2;
            // cout << tmp1 << '\n';
        }
        else
        {
            // cout << "tmp1 " << tmp1 << '\n';
            // cout << "num.front() " << num.front() << '\n';
            tmp1 += num.front();
            num.pop();
            sign.pop();
            // cout << tmp1 << '\n';
        }
    }
    cout << tmp1;
    return 0;
}