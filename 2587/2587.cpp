#include <iostream>

using namespace std;

int main()
{
    int num[5], sum = 0, tmp;
    for (int i = 0; i < 5; i++)
    {
        cin >> num[i];
        sum += num[i];
    }
    for (int i = 0; i < 4; i++)
    {
        for (int j = i + 1; j < 5; j++)
        {
            if (num[i] > num[j])
            {
                tmp = num[j];
                num[j] = num[i];
                num[i] = tmp;
            }
        }
    }
    cout << sum / 5 << '\n';
    cout << num[2];
    return 0;
}