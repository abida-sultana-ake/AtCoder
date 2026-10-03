def ri(): return int(input())
def rli(): return list(map(int, input().split()))
def rls(): return list(input())
def pli(a): return "".join(list(map(str, a)))

s = rls()
n = ri()
for i in range(5):
    for j in range(5):
        n -= 1
        if(n == 0):
            print(s[i]+s[j])
            break