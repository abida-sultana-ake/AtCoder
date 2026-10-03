#coding=UTF-8
#果たして鹿はじゃんけんが出来るのか

S=input()
offsets=0
for moji in S:
    if moji=='p':
        offsets=offsets+1

nagasa=len(S)

ans=nagasa//2 - offsets
print(ans)
