n = int(input())
s=[]
for i in range(n):
    s.append(int(input()))

s.sort(key=lambda x:x%10)

if sum(s) % 10 != 0:
    print(sum(s))
elif s[-1] % 10>0:
    print(sum(s)-min(filter(lambda x:x%10>0,s)))
else:
    print(0)

