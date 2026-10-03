N = int(raw_input())
p, q = 1, 1
for i in range(N):
    T, A = map(int, raw_input().split())
    k = max((T+p-1) / T, (A+q-1) / A)
    p, q = k*T, k*A
print (p+q)