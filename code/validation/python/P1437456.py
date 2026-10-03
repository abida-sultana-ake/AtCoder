def ri(): return int(input())
def rli(): return list(map(int, input().split()))
def rls(): return list(input())
def pli(a): return "".join(list(map(str, a)))

n = ri()
print(n+1 if n%2 == 1 else n-1)
