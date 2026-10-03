import numpy as np
A,B = map(int,input().split(' '))

pivot=A
count=0

while pivot!=B:
    if pivot<B: sign=1
    else: sign=-1
        
    diff=10
    if abs(B-pivot-sign*diff)>abs(B-pivot-sign*5): diff=5
    if abs(B-pivot-sign*diff)>abs(B-pivot-sign*1): diff=1
    
    pivot+=sign*diff
    count+=1

print(count)