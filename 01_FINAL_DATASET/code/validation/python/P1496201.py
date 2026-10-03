import sys
from sys import stdin,stdout
import bisect
N=input()
A=list(map(int,stdin.readline().strip().split(' ')))
count4=0
count1=0
for i in xrange(len(A)):
    if A[i]%4==0:
        count4+=1
    elif A[i]%2==1:
        count1+=1
if count4>=count1:
    if count4>0:
        print('Yes')
    else:
        if len(A)>1:
            print('Yes')
        else:
            print('No')
else:
    if count4<count1-1:
        print('No')
    elif count4==count1-1:
        if len(A)==count4+count1:
            print('Yes')
        else:
            print('No')
    else:
        print('No')
            
 