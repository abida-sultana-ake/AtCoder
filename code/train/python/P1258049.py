a,b,c=map(int,input().split())
s=set()
n=1
while (a*n)%b not in s:
    s.add((a*n)%b)
    n += 1
print('YES' if c in s else 'NO')