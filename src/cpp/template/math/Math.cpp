//
// Created by chenqwwq on 2024/6/17.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

int MOD = 10007;

// 计算 C(n,m)
//int combination(int n, int m) {
//    int ans = 1;
//    for (int i = n - m + 1; i < n; i++) {
//        ans = (ans * i % MOD);
//    }
//
//    while (m) ans /= m--;
//    return m;
//}

long long combination(int n, int m) {
    if (n < 0 || m < 0 || m > n) {
        return 0;
    }

    m = min(m, n - m);
    long long ans = 1;
    for (int i = 1; i <= m; i++) {
        __int128 next = static_cast<__int128>(ans) * (n - m + i) / i;
        if (next > numeric_limits<long long>::max()) {
            throw overflow_error("combination result exceeds long long");
        }
        ans = static_cast<long long>(next);
    }
    return ans;
}


// 求最大公应数(辗转相除法
int gcd(int a, int b) {
    if (!b) return a;
    return gcd(b, a % b);
}
