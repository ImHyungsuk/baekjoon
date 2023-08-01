#include <iostream>
#include <set>
#include <string>

using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    string S, tmp;
    set<string> list;
    int cnt = 0;
    cin >> S;
    for (int i = 1; i < S.length() + 1; i++)
    {
        for (int j = 0; j < S.length() + 1 - i; j++)
        {
            tmp = S.substr(j, i);
            list.insert(tmp); // insert 함수에서 애초에 존재하는 값은 insert하지 않음
        }
    }
    cout << list.size();
    return 0;
}