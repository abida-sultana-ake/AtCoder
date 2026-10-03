l=int(raw_input())
b=[int(raw_input()) for _ in xrange(l)]
check=0
for i in xrange(l):
    check^=b[i]
if check!=0:
    print(-1)
else:
    ans=[0]
    for i in xrange(l):
        ans.append(b[i]^ans[i])
        print(ans[i])