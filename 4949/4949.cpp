#include <iostream>
#include <stack>

using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    char tmp[100];
    stack<char> st;
    while (1)
    {
        cin.getline(tmp, 101, '\n');
        if (tmp[0] == '.')
            break;
        int j = 0;
        while (tmp[j] != '.')
        {
            if (tmp[j] == '(' || tmp[j] == '[')
                st.push(tmp[j]);
            else if (tmp[j] == ')')
            {
                if (!st.empty() && st.top() == '(')
                    st.pop();
                else
                {
                    st.push(tmp[j]);
                    break;
                }
            }
            else if (tmp[j] == ']')
            {
                if (!st.empty() && st.top() == '[')
                    st.pop();
                else
                {
                    st.push(tmp[j]);
                    break;
                }
            }
            j++;
        }
        if (st.empty())
            cout << "yes\n";
        else
        {
            cout << "no\n";
            while (!st.empty())
                st.pop();
        }
    }

    return 0;
}