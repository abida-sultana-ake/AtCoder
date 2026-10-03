import itertools

N, M, L = map(int, input().split())
li = list(map(int, input().split()))
ANS = []
a = list(itertools.permutations(li, 3))

for i in range(6):
    ansa = N // a[i][0]
    ansb = M // a[i][1]
    ansc = L // a[i][2]
    ans = ansa * ansb * ansc
    ANS.append(ans)

print(max(ANS))
