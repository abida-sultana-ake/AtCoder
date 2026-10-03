def ri(): return int(input())
def rli(): return list(map(int, input().split()))
def rls(): return list(input())
def pli(a): return "".join(list(map(str, a)))

n, m = rli()
n = (n%12) + (m/60)
print(min(abs(n*30 - 6*m), 360-abs(n*30 - 6*m)))