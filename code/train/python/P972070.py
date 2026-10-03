s=input()
cur = s[0]
count=0
for i in range(1,len(s)):
    if cur!=s[i]:
        count+=1
        cur=s[i]
print(count)
