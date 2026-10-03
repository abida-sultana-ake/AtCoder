N, A, B = map(int, input().split())
ret = 0
for _ in range(N):
    s, d = input().split()
    ret += max(min(int(d), B), A) * (1 if s == 'East' else -1)

if ret == 0:
    print(0)
else:
    print('East' if ret > 0 else 'West', abs(ret))
