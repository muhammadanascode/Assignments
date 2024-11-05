#include <iostream>
#include <cstdlib> // Required for malloc
using namespace std;

int main()
{
    int n = 7;
    int I[n];
    int S[n];
    int sum = 0;

    for (int i = 1; i <= n; i++)
    {
        int mul = I[i];
        for (int j = i + 1; j <= n; j++)
        {
            mul *= S[j];
        }
        sum += mul;
    }
    return 0;
}