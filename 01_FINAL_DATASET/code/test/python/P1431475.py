def ri(): return int(input())
def rli(): return list(map(int, input().split()))
def rls(): return list(input())
def pli(a): return "".join(list(map(str, a)))

a = ri()
b = ri()
n = ri()
for i in range(n, 500000):
    if(i%a == 0 and i%b == 0):
        print(i)
        break