N = int(input())
li = [0] * N
if N >= 3:
    li[2] = 1
    for i in range(3, N):
        li[i] = (li[i-1] + li[i-2] + li[i-3]) % 10007

print( li[N-1] )