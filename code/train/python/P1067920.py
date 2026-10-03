def reads():
  return [int(x) for x in input().split()]

(N, A, B) = reads()
X = reads()

result = 0
for i in range(1, N):
  result += min(A*(X[i] - X[i-1]), B)
print(result)