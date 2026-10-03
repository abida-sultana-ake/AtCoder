s=input()
t=input()
at="atcoder"
ans="You can win"
for (a,b) in zip(s,t):
    if a == b:
        continue
    if (a == "@" and b in at) or (b == "@" and a in at):
        continue
    else:
        ans="You will lose"
        break
print(ans)