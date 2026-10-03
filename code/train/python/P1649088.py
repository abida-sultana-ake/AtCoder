n,k = map(int,input().split())
s = list(input())

def enable(s,t,k,a):
    t1 = list(t)
    t1.append(a)
    for i in range(len(t1)):
        if s[i] != t1[i]: k -= 1
    s2 = s[len(t1):]
    t2 = list(s)
    for l in t1:
        t2.pop(t2.index(l))
    for i in s2:
        if i in t2:
            t2.pop(t2.index(i))
    k -= len(t2)
    return k >= 0

ss = sorted(s)
t = []
for i in range(n):
    for l in ss:
        if enable(s,t,k,l):
            t.append(l)
            ss.pop(ss.index(l))
            break
print("".join(t))
