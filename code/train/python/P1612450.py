A=[ int(x) for x in input().split() ]
B=[ int(x) for x in input().split() ]
print(sum([ max(a,b) for (a,b) in zip(A,B) ]))