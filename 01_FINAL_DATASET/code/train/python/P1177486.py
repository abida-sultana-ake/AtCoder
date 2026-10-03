X = int(input())
s = 0
for t in range(10**9):
    if s >= X:
        print(t-1)
        break
    s += t
