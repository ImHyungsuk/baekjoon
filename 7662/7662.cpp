#include <bits/stdc++.h>

using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    int T, k, cnt = 0;
    priority_queue<long> max_q;
    priority_queue<long, vector<long>, greater<long>> min_q;
    map<int, int> m;
    int n;
    char op;
    cin >> T;
    for (int i = 0; i < T; i++)
    {
        cin >> k;
        for (int j = 0; j < k; j++)
        {
            cin >> op >> n;
            if (op == 'D')
            {
                if (cnt == 0)
                    continue;
                else
                {
                    if (n == 1)
                    {
                        while (!max_q.empty() && m[max_q.top()] == 0)
                            max_q.pop();
                        m[max_q.top()]--;
                        max_q.pop();
                        cnt--;
                    }
                    else if (n == -1)
                    {
                        while (!min_q.empty() && m[min_q.top()] == 0)
                            min_q.pop();
                        m[min_q.top()]--;
                        min_q.pop();
                        cnt--;
                    }
                    while (!max_q.empty() && m[max_q.top()] == 0)
                        max_q.pop();
                    while (!min_q.empty() && m[min_q.top()] == 0)
                        min_q.pop();
                }
            }
            else if (op == 'I')
            {
                max_q.push(n);
                min_q.push(n);
                m[n]++;
                cnt++;
            }
        }
        // cout << cnt << "\n";
        if (max_q.empty() || min_q.empty())
            cout << "EMPTY\n";
        else
            cout << max_q.top() << " " << min_q.top() << "\n";
        cnt = 0;
        while (!max_q.empty())
            max_q.pop();
        while (!min_q.empty())
            min_q.pop();
        m.clear();
    }
    return 0;
}