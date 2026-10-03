s=list(str(input()))

ans=''
for i in s:
    if i in ['0','1','2','3','4','5','6','7','8','9']:
        ans += i

print(ans)