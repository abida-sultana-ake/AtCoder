def ri(): return int(input())
def rli(): return list(map(int, input().split()))
def rls(): return list(input())
def pli(a): return "".join(list(map(str, a)))

a,b,c,k = rli()
s,t = rli()
ans = a*s + b*t
if(s+t >= k):
    ans -= c*(s+t)
print(ans)