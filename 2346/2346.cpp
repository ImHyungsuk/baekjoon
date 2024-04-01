#include <iostream>
#include <deque>

using namespace std;

int main()
{
    int N, tmp;
    deque<pair<int, int>> dq;
    cin >> N;
    for (int i = 0; i < N; i++)
    {
        cin >> tmp;
        dq.push_back(make_pair(i + 1, tmp));
    }
    tmp = dq.front().second;
    cout << dq.front().first << " ";
    dq.pop_front();
    while (!dq.empty())
    {
        if (tmp < 0)
        {
            tmp *= -1;
            for (int i = 0; i < tmp; i++)
            {
                dq.push_front(dq.back());
                dq.pop_back();
            }
        }
        else
        {
            for (int i = 0; i < tmp - 1; i++)
            {
                dq.push_back(dq.front());
                dq.pop_front();
            }
        }
        tmp = dq.front().second;
        cout << dq.front().first << " ";
        dq.pop_front();
    }

    return 0;
}