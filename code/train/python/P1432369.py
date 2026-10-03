def ri(): return int(input())
def rli(): return list(map(int, input().split()))
def rls(): return list(input())
def pli(a): return "".join(list(map(str, a)))

n = ri()
a, b = rli()
k = ri()
p = [a]
p = p + rli()
p.append(b)
if(len(set(p)) == len(p)):
    print("YES")
else:
    print("NO")