input()
s=input()
print(sum(s.count(x)*y for x,y in zip('ABCD',[4,3,2,1]))/len(s))