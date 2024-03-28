#include <iostream>

using namespace std;

int main()
{
    char A[5][15] = {
        0,
    };
    string a;
    for (int i = 0; i < 5; i++)
    {
        cin >> a;
        int j = 0;
        while (a[j])
        {
            A[i][j] = a[j];
            j++;
        }
    }
    for (int i = 0; i < 15; i++)
    {
        for (int j = 0; j < 5; j++)
        {
            if (A[j][i] >= 48 && A[j][i] <= 57)
                cout << A[j][i];
            else if (A[j][i] >= 65 && A[j][i] <= 90)
                cout << A[j][i];
            else if (A[j][i] >= 97 && A[j][i] <= 122)
                cout << A[j][i];
        }
    }
    return 0;
}