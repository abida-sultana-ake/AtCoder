import collections
n = int(input())
a = list(map(int, input().split()))

MOD = 10**9 + 7
cnt = collections.Counter(a)
if n%2 == 0:
    ans = 1
    for i in range(1,n, 2):
        if cnt[i] == 2:
            ans = ans*2%MOD
        else:
            print(0)
            exit()
else:
    ans = 1
    for i in range(2,n, 2):
        if cnt[i] == 2:
            ans = ans*2%MOD
        else:
            print(0)
            exit()
    if cnt[0] != 1:
        print(0)
        exit()
print(ans)