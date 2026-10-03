e=list(map(int,input().split()))
b=int(input())
s=0
ok=0
for l in map(int, input().split()):
 s+=l in e
 ok+=l==b
print(0 if s<3 else 8-s if s<5 else 8-s-ok if s<6 else 1)