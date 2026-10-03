i = 0
N = int(input())
while N > 1:
    N //= 2
    i += 1

if N == 0:
    print(i)
    for j in range(i):
        print(2)
elif N == 1:
    print(i + 1)
    print(1)
    for j in range(i):
        print(2)
