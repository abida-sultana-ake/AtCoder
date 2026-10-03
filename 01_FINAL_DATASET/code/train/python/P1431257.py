def ri(): return int(input())
def rli(): return list(map(int, input().split()))
def rls(): return list(input())
def pli(a): return "".join(list(map(str, a)))

ans = 0
n,s,t = rli()
w = ri()
if(s <= w and w <= t):
    ans += 1
for i in range(n-1):
    w += ri()
    if(s <= w and w <= t):
        ans += 1
print(ans)