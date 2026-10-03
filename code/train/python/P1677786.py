n=int(input())
k=int(input())
a=0
for x in [int(i) for i in input().split()]:
    a+=min(x,abs(k-x))
print(a*2)