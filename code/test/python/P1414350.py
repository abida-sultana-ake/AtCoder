l = list(map(str, input().split()))


if (l[0][-1] == l[1][0]) and (l[1][-1] == l[2][0]):
  print('YES')
else:
  print('NO')
