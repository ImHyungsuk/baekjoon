#include <iostream>
#include <queue>

using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    int N, tmp;
    string st;
    queue<int> ret;
    cin >> N;
    for (int i = 0; i < N; i++)
    {
        cin >> st;
        if (st == "push")
        {
            cin >> tmp;
            ret.push(tmp);
        }
        else if (st == "pop")
        {
            if (ret.empty())
                cout << -1 << '\n';
            else
            {
                cout << ret.front() << "\n";
                ret.pop();
            }
        }
        else if (st == "size")
            cout << ret.size() << '\n';
        else if (st == "empty")
        {
            if (ret.empty())
                cout << 1 << '\n';
            else
                cout << 0 << '\n';
        }
        else if (st == "front")
        {
            if (ret.empty())
                cout << -1 << '\n';
            else
                cout << ret.front() << '\n';
        }
        else if (st == "back")
        {
            if (ret.empty())
                cout << -1 << '\n';
            else
                cout << ret.back() << '\n';
        }
    }
    return 0;
}