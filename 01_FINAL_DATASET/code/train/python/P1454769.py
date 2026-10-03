n,k=input().split();s=0
for x in sorted(map(float,input().split()))[-int(k):]:s=(s+x)/2
print(s)