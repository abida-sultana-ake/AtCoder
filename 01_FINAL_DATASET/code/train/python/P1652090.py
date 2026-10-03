N, W = [int(n) for n in input().split()]

values = [[] for n in range(4)]
w, v = [int(n) for n in input().split()]
w_0 = w
values[0].append(v)

sum_values = [[0] for n in range(4)]


for i in range(1, N):
  w, v = [int(n) for n in input().split()]
  values[w-w_0].append(v)

for i in range(4):
  values[i].sort(reverse=True)
  s = 0
  for j in range(len(values[i])):
    s += values[i][j]
    sum_values[i].append(s)

res = 0
for i in range(len(values[0])+1):
  for j in range(len(values[1])+1):
    for k in range(len(values[2])+1):
      for l in range(len(values[3])+1):
        if (i*w_0 + j*(w_0+1) + k*(w_0+2) + l*(w_0+3))<=W:
          res = max(res, sum_values[0][i]+sum_values[1][j]+sum_values[2][k]+sum_values[3][l])


print(res)