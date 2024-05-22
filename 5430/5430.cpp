#include <bits/stdc++.h>
using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    int T, n, flag = 0, error = 0;

    string s, num;
    deque<int> dq;
    stack<int> st;
    cin >> T;
    for (int i = 0; i < T; i++)
    {
        cin >> s;
        cin >> n;
        cin >> num;
        int tmp2 = 0;
        int j = 0, k = 0;
        while (num[k] && j < n)
        {
            if (num[k] >= '0' && num[k] <= '9')
            {
                tmp2 = tmp2 * 10 + num[k] - '0';
                // cout << tmp2 << '\n';
                if (num[k + 1] < '0' || num[k + 1] > '9')
                {
                    dq.push_back(tmp2);
                    tmp2 = 0;
                }
            }
            k++;
        }
        // cout << arr[0];
        while (s[j])
        {
            if (s[j] == 'R')
            {
                flag++;
            }
            else if (s[j] == 'D')
            {
                if (dq.empty())
                {
                    cout << "error\n";
                    error = 1;
                    j++;
                    break;
                }
                else
                {
                    if (flag % 2 == 0)
                    {
                        dq.pop_front();
                        n--;
                    }
                    else
                    {
                        dq.pop_back();
                        n--;
                    }
                }
            }
            j++;
        }
        if (n == 0 && error == 0)
            cout << "[]\n";
        else
        {
            if (!dq.empty())
            {
                cout << "[";
                while (!dq.empty())
                {
                    if (flag % 2 == 0)
                    {
                        cout << dq.front();
                        dq.pop_front();
                        if (!dq.empty())
                            cout << ",";
                    }
                    else
                    {
                        cout << dq.back();
                        dq.pop_back();
                        if (!dq.empty())
                            cout << ",";
                    }
                }
                cout << "]\n";
            }
        }
        error = 0;
        flag = 0;
        while (!dq.empty())
            dq.pop_front();
    }

    return 0;
}