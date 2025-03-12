#include <bits/stdc++.h>
using namespace std;
int main()
{
    int N, input;
    cin >> N;
    vector<int> v;
    for (int i = 0; i < N; i++)
    {
        cin >> input;
        v.push_back(input);
    }
    sort(v.begin(), v.end());
    input = 0;
    for (auto i = v.begin(); i != v.end(); i++)
    {
        input += (*i * N);
        // cout << input << "\n";
        N--;
    }
    cout << input;
    return 0;
}