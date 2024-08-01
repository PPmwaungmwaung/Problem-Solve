#include <iostream>
using namespace std;

int cash[201][201];

int calCaseNum(int goal, int slot)
{
    if(cash[goal][slot] != 0) {
        return cash[goal][slot];
    }

    long long caseSum = 0;
    for(int i = 0; i <= goal; i++) {
        caseSum += (calCaseNum(goal - i, slot - 1) % 1000000000);
    }
    cash[goal][slot] = caseSum % 1000000000;
    return cash[goal][slot];
}

int main()
{
    int n, k;
    cin >> n >> k;

    for(int i=0;i<=200;i++) {
        for(int j=0;j<=200;j++) {
            cash[i][j] = 0;
        }
    }
    for(int i=0;i<=200;i++) {
        cash[i][1] = 1;
    }

    cout << calCaseNum(n, k);
    return 0;
}
