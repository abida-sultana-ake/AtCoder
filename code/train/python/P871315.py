n=int(input())
c=1
r=n//c
ans=n
while r>=c:
    ca=n-r*c+r-c
    ans = ca if ca<ans else ans
    c+=1
    r=n//c
print(ans)