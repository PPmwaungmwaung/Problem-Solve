#include <iostream>
using namespace std;

#define MAX_E 15
#define MAX_S 28
#define MAX_M 19

int main()
{
	int targetE, targetS, targetM, curE = 1, curS = 1, curM = 1, year = 1;

	cin >> targetE >> targetS >> targetM;

	while (targetE != curE || targetS != curS || targetM != curM) {
		curE = curE + 1 <= MAX_E ? curE + 1 :  1;
		curS = curS + 1 <= MAX_S ? curS + 1 :  1;
		curM = curM + 1 <= MAX_M ? curM + 1 :  1;

		year++;
	}

	cout << year;
	return 0;
}
