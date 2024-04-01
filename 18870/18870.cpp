#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    int N, tmp;
    int arr[10000];
    vector<int> X;
    for (int i = 0; i < N; i++)
    {
        cin >> arr[i];
        X.push_back(arr[i]);
    }
    sort(X.begin(), X.end());
    X.erase(unique(X.begin(), X.end()), X.end());
    for (int i = 0; i < N; i++)
    {
        int idx = lower_bound(X.begin(), X.end(), arr[i]) - X.begin();
        // lower_bound는 찾고자 하는 값 이상이 처음 나오는 위치, 고로 X.begin()위치를 빼준다.
        cout << idx << " ";
    }

    return 0;
}