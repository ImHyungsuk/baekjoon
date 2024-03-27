#include <iostream>
#include <cmath>
#include <queue>

using namespace std;

int main()
{
    queue<int> num;
    string N;
    int B, ret = 0;
    cin >> N >> B;
    int i = 0;
    while (N[i])
    {
        if (N[i] >= 48 && N[i] <= 57)
            num.push(N[i] - 48);
        else if (N[i] >= 65 && N[i] <= 90)
            num.push(N[i] - 65 + 10);
        i++;
    }
    i--;
    while (!num.empty())
    {
        ret += pow(B, i) * num.front();
        i--;
        num.pop();
    }
    cout << ret;

    return 0;
}