def rren(): return list(map(int, input().split()))

N, oyu = rren()
T = rren()

Ans = 0
for i in range(N-1):
    Ans += oyu if T[i+1] - T[i] >= oyu else T[i+1] - T[i]

print(Ans + oyu)