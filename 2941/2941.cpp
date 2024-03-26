#include <iostream>

using namespace std;

int main()
{
    string a;
    int cnt = 0;
    cin >> a;
    int i = 0;
    while (a[i] != 0)
    {
        if (a[i] == 'c')
        {
            i++;
            if (a[i] == '=' || a[i] == '-')
            {
                i++;
                cnt++;
            }
            else
                cnt++;
        }
        else if (a[i] == 'd')
        {
            i++;
            if (a[i] == '-')
            {
                i++;
                cnt++;
            }
            else if (a[i] == 'z')
            {
                i++;
                if (a[i] == '=')
                {
                    i++;
                    cnt++;
                }
                else
                {
                    cnt++;
                    i--;
                }
            }
            else
                cnt++;
        }
        else if ((a[i] == 'l' && a[i + 1] == 'j') || (a[i] == 'n' && a[i + 1] == 'j') || (a[i] == 's' && a[i + 1] == '=') || (a[i] == 'z' && a[i + 1] == '='))
        {
            i += 2;
            cnt++;
        }
        else
        {
            cnt++;
            i++;
        }
    }
    cout << cnt << '\n';
    return 0;
}