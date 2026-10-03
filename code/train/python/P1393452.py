# -*- coding: utf-8 -*-       

n = input()
a = map(int, raw_input().split())
alen = len(a)
b = [0]*alen
if(alen%2 == 0):
    for i,j in enumerate(range(0,alen,2)):
        b[i] = a[alen-1-j]
    for i,j in enumerate(range(0,alen,2)):
        b[alen/2+i] = a[j]
else:
    for i in range(0,alen/2+1):
        b[i] = a[alen-1-2*i]
    for i in range(0,alen/2):
        b[alen/2+1+i] = a[2*i+1]

print(' '.join(map(str,b)))
    
