def ri(): return int(input())
def rli(): return list(map(int, input().split()))
def rls(): return list(input())
def pli(a): return "".join(list(map(str, a)))

s = rls()
k = ri()
pw = set()
for i in range(len(s)+1 - k):
    pw.add(pli(s[i:i+k]))

print(len(pw))
