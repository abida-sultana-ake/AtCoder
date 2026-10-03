from sys import stdin
mod=10**9+7
def expo(n):
    if n<=0:
        return 1
    if n%2==0:
        return expo(n//2)*expo(n//2)%mod
    else:
        return 2*expo(n//2)*expo(n//2)%mod

n=int(input())
differences=list(map(int,stdin.readline().split()))
repetition=0
nbDiff=[0]*n
places=[0]*n
possible=True
moitie=n//2
for i in range(n):
    difference=differences[i]
    moitieDiff=difference//2
    if nbDiff[difference]==1:
        repetition+=1
    nbDiff[difference]+=1    
    
    if n%2==1:
        places[moitie+moitieDiff]+=1
        places[moitie-moitieDiff]+=1
    else:
        places[moitie+moitieDiff]+=1
        places[moitie-moitieDiff-1]+=1

for i in range(n):
    if places[i]!=2:
        possible=False

if possible:
    print(expo(repetition))
else:
    print(0)