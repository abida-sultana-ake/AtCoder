s=raw_input()
n=len(s)
ans=[]
for i in xrange(n):
    if s[i]=="B" and ans==[]:
        continue
    if s[i]=="B":
        del ans[-1]
    elif s[i]=="0":
        ans.append("0")
    else:
        ans.append("1")
print("".join(ans))