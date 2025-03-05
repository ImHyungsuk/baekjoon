#include <bits/stdc++.h>
using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    int M, num;
    string op;
    bool arr[21] = {
        false,
    };
    cin >> M;
    for (int i = 0; i < M; i++)
    {
        // cout << i + 1 << "th\n";
        cin >> op;
        if (op == "add")
        {
            cin >> num;
            arr[num] = true;
        }
        else if (op == "remove")
        {
            cin >> num;
            arr[num] = false;
        }
        else if (op == "check")
        {
            cin >> num;
            if (arr[num])
            {
                cout << "1\n";
            }
            else
            {
                cout << "0\n";
            }
        }
        else if (op == "toggle")
        {
            cin >> num;
            arr[num] = !arr[num];
        }
        else if (op == "all")
        {
            for (int j = 1; j < 21; j++)
            {
                arr[j] = true;
            }
        }
        else
        {
            for (int j = 1; j < 21; j++)
            {
                arr[j] = false;
            }
        }
    }

    return 0;
}