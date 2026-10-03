def ri(): return int(input())
def rli(): return list(map(int, input().split()))
def rls(): return list(input())
def pli(a): return "".join(list(map(str, a)))


N, K = rli()
D = set(map(int, input().split()))
All = {1,2,3,4,5,6,7,8,9,0}
All.difference_update(D)

ans = N
for i in range(N*10):
    ls = set(map(int, str(ans)))
    ls.difference_update(All)
    if(ls == set()):
        print(ans)
        break
    ans += 1
