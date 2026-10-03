# pushpush
n = int(input())
a = list(map(int, input().split()))

flag = [n-2*i if i<n/2 else int((i-n/2)*2+1)  for i in range(n)]
b = [str(a[flag[i]-1]) for i in range(n)]
print(' '.join(b))