# coding: utf-8
n=int(input())
table=[]
for n in map(int,input().split()):
    while n%2==0:
        n=n//2
    table.append(n)
print(len(set(table)))