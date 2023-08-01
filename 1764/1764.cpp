#include <iostream>
#include <set>

using namespace std;

int main()
{
    int N, M;
    string tmp;
    int cnt = 0;
    set<string> hear, ret;
    cin >> N >> M;
    for (int i = 0; i < N; i++)
    {
        cin >> tmp;
        hear.insert(tmp);
    }
    for (int i = 0; i < M; i++)
    {
        cin >> tmp;
        if (hear.find(tmp) != hear.end())
        {
            ret.insert(tmp);
            cnt++;
        }
    }
    cout << cnt << '\n';
    for (set<string>::iterator iter = ret.begin(); iter != ret.end(); iter++)
        cout << *iter << '\n';

    return 0;
}