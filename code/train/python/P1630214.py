n,m = map(int,input().split())
bin = [0]*(m+1)
s = 0
for i in range(n):
    a,b,c = map(int,input().split())
    bin[a-1]+= c
    bin[b]-= c
    s += c
for i in range(m):
    bin[i+1]+=bin[i]
print(s-min(bin[:-1]))