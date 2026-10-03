n = int(input())
s = input().rstrip()
def check(is_sheep, s, i, n):
  a = i - 1 if i != 0 else n-1
  b = i + 1 if i != n - 1 else 0
  if (s[i] == 'o') == is_sheep[i]:
    return is_sheep[a] == is_sheep[b]
  else:
    return is_sheep[a] != is_sheep[b]

def solve(n, s):
  # SS
  for x, y in [(True, True), (True, False), (False, True), (False, False)]:
    is_sheep = [None] * n
    is_sheep[0] = x
    is_sheep[1] = y
    for i in range(2, n):
      if is_sheep[i-1]:
        if s[i-1] == 'o':
          is_sheep[i] = is_sheep[i-2]
        else:
          is_sheep[i] = not is_sheep[i-2]
      else:
        if s[i-1] == 'o':
          is_sheep[i] = not is_sheep[i-2]
        else:
          is_sheep[i] = is_sheep[i-2]
    if check(is_sheep, s, 0, n) and check(is_sheep, s, n - 1, n):
      return is_sheep
  return None

result = solve(n, s)

if result:
  print("".join(["S" if b else "W" for b in result]))
else:
  print(-1)
