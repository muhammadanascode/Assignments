#include <iostream>
using namespace std;

int main()
{
    int n = 7;
    int I[n] = {1, 2, 3, 4, 5, 6, 7}; // Example initialization for I
    int S[n] = {1, 1, 1, 1, 1, 1, 1}; // Example initialization for S
    int sum = 0;

    // Corrected indexing to start from 0 and stop before n
    for (int i = 0; i < n; i++)
    {
        int mul = I[i];
        for (int j = i + 1; j < n; j++)
        {
            mul *= S[j];
        }
        sum += mul;
    }

    cout << "Sum: " << sum << endl;
    return 0;
}
