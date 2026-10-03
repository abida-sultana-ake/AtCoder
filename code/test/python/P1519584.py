a = []
n = 0

N = int(input())
for i in range(N):
    a.append(int(input()))
a.sort()
for i in range(N-1):
    if a[i] == a[i+1]:
        n += 1
print(n) 
