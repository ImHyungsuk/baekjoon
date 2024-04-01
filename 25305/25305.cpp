#include <iostream>

using namespace std;

int main()
{
    int N, k, tmp;
    int score[1000];
    cin >> N >> k;
    for (int i = 0; i < N; i++)
    {
        cin >> score[i];
    }
    for (int i = 0; i < N - 1; i++)
    {
        for (int j = i + 1; j < N; j++)
        {
            if (score[i] < score[j])
            {
                tmp = score[i];
                score[i] = score[j];
                score[j] = tmp;
            }
        }
    }
    cout << score[k - 1];

    return 0;
}