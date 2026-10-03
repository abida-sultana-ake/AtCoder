N, S, T = [int(i) for i in input().split()]
W = int(input())
A = []
for i in range(N-1):
    A.append(int(input()))

if S <= W <= T:
    count = 1
else:
    count = 0

for i in range(N-1):
    W += A[i]
    if S <= W <= T:
        count += 1

print(count)
