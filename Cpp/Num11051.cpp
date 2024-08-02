#include <iostream>
using namespace std;

int prime[1001], primeSize;
bool isPrime[1001];
int nume[1001], deno[1001];

void initPrime()
{
	for (int i = 0; i < 1001; i++) {
		isPrime[i] = true;
	}

	for (int i = 2; i < 1001; i++) {
		if (!isPrime[i]) { continue; }

		prime[primeSize++] = i;
		for (int j = 2; i * j < 1001; j++) {
			isPrime[i * j] = false;
		}
	}
}

void factorization(int target, int facArr[])
{
	while (target != 1) {
		for (int i = 0; i < primeSize; i++) {
			if (target % prime[i] == 0) {
				target /= prime[i];

				facArr[prime[i]] += 1;

				break;
			}
		}
	}
}

int pow(int a, int b)
{
	int result = 1;
	for (int i = 0; i < b; i++) {
		result *= a;
	}
	return result;
}

int main()
{
	int n, k, result = 1;

	cin >> n >> k;

	if (k > n / 2) {
		k = n - k;
	}

	initPrime();

	for (int i = 0; i < k; i++) {
		factorization(n - i, nume);
	}
	for (int i = 2; i <= k; i++) {
		factorization(i, deno);
	}

	for (int i = 2; i <= n; i++) {
		if (nume[i] - deno[i] != 0) {
			result *= pow(i, (nume[i] - deno[i]));
			result %= 10007;
		}
	}
	cout << result;
	return 0;
}
