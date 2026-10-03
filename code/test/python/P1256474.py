NT = list(map(int,input().split()))

t = list(map(int,input().split()))


ans = NT[0]*NT[1]

for i in range(len(t)-1):
    if t[i+1]-t[i]<NT[1]:
        ans -= NT[1]-t[i+1]+t[i]
print(ans)