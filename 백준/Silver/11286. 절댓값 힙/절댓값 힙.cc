#include <bits/stdc++.h>
using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);

    int N, x;
    priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
    cin >> N;
    for (int i = 0; i < N; i++)
    {
        cin >> x;
        if (x == 0)
        {
            if (pq.empty())
                cout << "0\n";
            else
            {
                cout << pq.top().second << "\n";
                pq.pop();
            }
        }
        else
            pq.push(make_pair(x < 0 ? -1 * x : x, x));
    }
    return 0;
}