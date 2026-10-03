li = []
n = int(input())
for x in range(n):
    a = list(input())
    a.sort()
    li.append(a)
a = set(li[0])
pri = []
for x in a:
    nu = []
    for l in li:
      nu.append(l.count(x))
    pri.append(min(nu))
ge = []
for x,y in zip(a,pri):
    ge.append(x * y)
ge.sort()
st = "".join(ge)
print(st)