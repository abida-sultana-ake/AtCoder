from collections import defaultdict
n=int(input())
arr=[]
for _ in range(n):
    dd=defaultdict(int)
    line=list(input())
    for c in line:
        dd[c]+=1
    arr.append(dd)

#print(arr)

for c in list('abcdefghijklmnopqrstuvwxyz'):
    minc=51
    for i in range(n):
        minc=min(arr[i][c],minc)
    print(c*minc,end='')
print('')
