s=raw_input()
cntg=0
cntp=0
ans=0
for i in xrange(len(s)):
    if cntg>cntp:
        if s[i]=="g":
            cntp+=1
            ans+=1
        else:
            cntp+=1
    else:
        if s[i]=="g":
            cntg+=1
        else:
            cntg+=1
            ans-=1
print(ans)
