s=raw_input()
ans=[]
for i in s:
    if i.isdigit():
        ans.append(i)
print("".join(ans))