#include <iostream>
#include <deque>

using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    deque<int> dq;
    int N, tmp1, X;
    cin >> N;
    for (int i = 0; i < N; i++)
    {
        cin >> tmp1;

        if (tmp1 == 1)
        {
            cin >> X;
            dq.push_front(X);
        }
        else if (tmp1 == 2)
        {
            cin >> X;
            dq.push_back(X);
        }
        else if (tmp1 == 3)
        {
            if (!dq.empty())
            {
                cout << dq.front() << '\n';
                dq.pop_front();
            }
            else
                cout << "-1\n";
        }
        else if (tmp1 == 4)
        {
            if (!dq.empty())
            {
                cout << dq.back() << '\n';
                dq.pop_back();
            }
            else
                cout << "-1\n";
        }
        else if (tmp1 == 5)
            cout << dq.size() << '\n';

        else if (tmp1 == 6)
        {
            if (dq.empty())
                cout << "1\n";
            else
                cout << "0\n";
        }
        else if (tmp1 == 7)
        {
            if (!dq.empty())
                cout << dq.front() << '\n';
            else
                cout << "-1\n";
        }
        else if (tmp1 == 8)
        {
            if (!dq.empty())
                cout << dq.back() << '\n';
            else
                cout << "-1\n";
        }
    }
    return 0;
}