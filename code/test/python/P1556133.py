s=str(input())
t=""
aiueo="aiueo"
for i in range(len(s)):
  if s[i] not in aiueo: t+=s[i]
print(t)