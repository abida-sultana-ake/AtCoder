n = int(input())
a = []

for i in range(n):
    a.append(int(input()))

a.sort(reverse=True)

for i in range(n):
    if a[i] > a[i+1]:
        print(a[i+1])
        break
