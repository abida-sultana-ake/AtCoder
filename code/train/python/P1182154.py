MAX = 100000


def F(A, B):
    return max(len(str(A)), len(str(B)))

N = int(input())

res = 100
for a in range(1, MAX):
    if N % a == 0:
        res = min(res, F(a, N // a))

print(res)