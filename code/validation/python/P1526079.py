#coding=UTF-8
hou=1000000007

N=int(input())

Sone=input()
Stwo=input()

tateyoko=[]
idx=0
owari=len(Sone)
while idx < owari:
    if Sone[idx] == Stwo[idx]:
        #tate
        tateyoko.append(1)
        idx=idx+1
    else:
        #yoko
        tateyoko.append(2)
        idx=idx+2

ans=1
mae=None
for mono in tateyoko:
    if mono==1:
        #tate
        if mae==None:
            kake=3
        elif mae==1:
            kake=2
        else:
            kake=1
    else:
        #yoko
        if mae==None:
            kake=6
        elif mae==1:
            kake=2*1
        else:
            kake=1+2

    mae=mono
    ans=(ans*kake)%hou

print(ans)
