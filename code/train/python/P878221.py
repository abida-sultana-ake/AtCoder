memo = set([])
def f(a):
    global ans
    ans += eval('+'.join(a))
    if len(a) < 3 : return
    for i in range(len(a)-1):
        b = a[:i] + [a[i]+a[i+1]]
        if i != len(a)-2 : b += a[-(len(a)-2-i):]
        c = '+'.join(b)
        if not c in memo:
            memo.add(c)
            f(b)
s = input()
l = list(s)
ans = int(s)
if len(l)>1:
    f(l)
print(ans)