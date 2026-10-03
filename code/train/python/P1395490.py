n = int(input())
a = input().split(' ')
b = []
inds = [0] * n

for i in range(int(n/2)):
    inds[i] = n-2*i
    inds[n-1-i] = n-2*i-1
if n % 2 == 1:
    inds[int(n/2)] = n-2*int(n/2)

for i, ind in enumerate(inds):
    print(a[ind-1], end="")
    if i != n-1:
        print(' ', end="")
print('')