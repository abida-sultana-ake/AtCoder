S = input()
ans = S[0].upper()
for i in range(1,len(S)):
    ans += S[i].lower()
print(ans)
