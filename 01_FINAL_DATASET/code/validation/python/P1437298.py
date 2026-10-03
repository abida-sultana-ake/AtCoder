def ri(): return int(input())
def rli(): return list(map(int, input().split()))
def rls(): return list(input())
def pli(a): return "".join(list(map(str, a)))

n = ri()
s = input()
ans = -1
if(n % 2 == 1):
    ans = n//2
    tp = n % 3
    if(tp == 1):
        if(s != "bca" * (n // 3) + "b"):
            ans = -1
    elif(tp == 0):
        if(s != "abc" * (n // 3)):
            ans = -1
    else:
        if(s != "cab" * (n//3) + "ca"):
            ans = -1
print(ans)
