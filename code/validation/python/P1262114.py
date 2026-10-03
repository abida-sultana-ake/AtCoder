N=int(input())
COM=input()
TAB='ABXY'
changeflag = 0

ans = N;

for i in range(4):
    for j in range(4):
        for k in range(4):
            for l in range(4):
                tmp = N
                for m in range(N-1):
                    if changeflag == 0:
                        if TAB[i] == COM[m] and TAB[j] == COM[m+1] or TAB[k] == COM[m] and TAB[l] == COM[m+1]:
                            tmp -= 1
                            changeflag = 1
                    else:
                        changeflag = 0
                if ans>=tmp :
                    ans = tmp
                changeflag = 0
print(ans)
