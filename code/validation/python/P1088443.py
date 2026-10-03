n = int(input())
A = list(map(int, input().split()))
m = n - len(set(A))
print(n - m - (m % 2 == 1))