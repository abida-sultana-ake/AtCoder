i=set(map(int,input().split()))
a={1,3,5,7,8,10,12}
b={4,6,9,11}
c={2}
print(['No','Yes'][i<=a or i<=b or i<=c])