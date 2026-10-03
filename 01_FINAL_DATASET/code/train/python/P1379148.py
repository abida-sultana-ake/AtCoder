N = int(input())
a = []
for i in range(N):
    a.append(int(input()))
x = [False]*N
n,i = (0, 0)
while x[n] == False:
    x[n] = True
    n = a[n]-1
    i+=1
    if n==1:
        print(i)
        break
else:
    print(-1)
