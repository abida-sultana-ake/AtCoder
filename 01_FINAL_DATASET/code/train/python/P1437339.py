def ri(): return int(input())
def rli(): return list(map(int, input().split()))
def rls(): return list(input())
def pli(a): return "".join(list(map(str, a)))

n, a, b = rli()
d = 0
for i in range(n):
    s, d_tmp = list(input().split())
    s = 1 if s == "East" else -1
    d += (max(min(int(d_tmp), b), a) * s)

if(d > 0):
    print("East",d)
elif(d == 0):
    print(0)
else:
    print("West", -d)
