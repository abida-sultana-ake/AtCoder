MOD = 10**9 + 7
A, B, C = [int(input()) % MOD for _ in range(3)]
AB = (A*B) % MOD
BC = (B*C) % MOD
CA = (C*A) % MOD
c = ((BC - AB) * pow((CA - BC + AB), MOD-2, MOD)) % MOD
r = ((BC - CA) * pow((AB - BC + CA), MOD-2, MOD)) % MOD

print(r, c)