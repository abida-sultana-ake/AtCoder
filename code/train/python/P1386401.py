N = int(input())
s = []

for i in range(N) :
    s.append(int(input()))

ans = sum(s)
s.sort()

for i in range(N) :
    if ans%10 != 0 :
        print(ans)
        break
    elif s[i]%10 != 0:
        ans -= s[i]
else :
    print(0)