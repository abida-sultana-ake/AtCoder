dump = int(input())
K = int(input())
sum = 0
x = list(map(int, input().split()))
for x_i in x:
  sum += 2*min(x_i, K-x_i)
print(sum)