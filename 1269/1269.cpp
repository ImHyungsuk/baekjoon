#include <iostream>
#include <set>

using namespace std;

int main()
{
    int N, M;
    int tmp, cnt = 0;
    ;
    set<int> A, B;
    cin >> N >> M;
    for (int i = 0; i < N; i++)
    {
        cin >> tmp;
        A.insert(tmp);
    }
    for (int i = 0; i < M; i++)
    {
        cin >> tmp;
        B.insert(tmp);
    }
    for (set<int>::iterator iter = A.begin(); iter != A.end(); iter++)
    {
        if (B.find(*iter) != B.end())
            continue;
        else
            cnt++;
    }
    for (set<int>::iterator iter = B.begin(); iter != B.end(); iter++)
    {
        if (A.find(*iter) != A.end())
            continue;
        else
            cnt++;
    }
    cout << cnt;

    return 0;
}