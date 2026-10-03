N, a = list(map(int, input().split()))
k = int(input())
b = list(map(int, input().split()))

a -= 1
b = [x-1 for x in b]

def susumu(s, n):
    for i in range(n):
        s = b[s]
    return s

if k < 4*N:
    print(susumu(a, k)+1)
else:
    a = susumu(a, N)
    s = a
    m = 0
    for i in range(N):
        m += 1
        a = b[a]
        if a == s:
            break
    print(susumu(a, (k-N-m)%m)+1)