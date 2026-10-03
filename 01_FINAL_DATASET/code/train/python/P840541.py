s=input()
for w in range(2,min([3,len(s)])+1):
    for st in range(0,len(s)-w+1):
        if s[st]==s[st+w-1]:
            print(st+1,st+w)
            exit()
print(-1,-1)
