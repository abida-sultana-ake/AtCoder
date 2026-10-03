K = int(input())
N = 50
A = [i for i in range(N)]

q = K // N
r = K % N

A = [a+q for a in A]
for i in range(r):
  A[i] += N
  for j in range(N):
    if i != j:
      A[j] -= 1

print(N)
for i in range(N):
  if i != 0:
    print(" ", end="")
  print(A[i], end="")
print("")