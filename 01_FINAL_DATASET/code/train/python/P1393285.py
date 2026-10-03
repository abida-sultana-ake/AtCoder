n = int(input())
A = input().split()

if n == 1:
    print(A[0])
    exit()

elif n % 2 == 0:
    l1 = [A[n - 2 * i - 1] for i in range(n//2)]
    l2 = [A[2 * j] for j in range(n//2)]

else:
    l1 = [A[n - 2 * i - 1] for i in range(n//2 + 1)]
    l2 = [A[2 * j + 1] for j in range(n//2)]

print(" ".join(l1), " ".join(l2))
