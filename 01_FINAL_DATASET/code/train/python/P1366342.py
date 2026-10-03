A,B,C=map(int,input().split())
x=0
if A+B==C: x += 1
if A-B==C: x += 2
print('!+-?'[x])