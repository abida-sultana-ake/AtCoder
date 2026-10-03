N = 19
src = [raw_input() for i in range(N)]

def is_ok(c, limit): #limit: 0 or 1
  last_candidate = []
  
  # horizontal
  for i in range(N):
    n = 0
    for j in range(N):
      if src[i][j] == c:
        n += 1
        if n >= 5:
          if limit == 0 or n == 10: return False
          if len(last_candidate) == 0:
            for k in range(5):
              last_candidate.append((j-k,i))
          elif n == 5:
            for k in range(5):
              p = (j-k,i)
              if p in last_candidate:
                last_candidate = [p]
                break
            else:
              return False
          elif last_candidate[-1] == (j-5,i):
            last_candidate.pop()
      else:
        n = 0
  # vertical
  for i in range(N):
    n = 0
    for j in range(N):
      if src[j][i] == c:
        n += 1
        if n >= 5:
          if limit == 0 or n == 10: return False
          if len(last_candidate) == 0:
            for k in range(5):
              last_candidate.append((i,j-k))
          elif n == 5:
            for k in range(5):
              p = (i,j-k)
              if p in last_candidate:
                last_candidate = [p]
                break
            else:
              return False
          elif last_candidate[-1] == (i,j-5):
            last_candidate.pop()
      else:
        n = 0
  # diagonal (/)
  for i in range(2*N-1):
    n = 0
    y = max(0, i-N+1)
    for j in range(N - abs(N-1-i)):
      if src[y+j][i-y-j] == c:
        n += 1
        if n >= 5:
          if limit == 0 or n == 10: return False
          if len(last_candidate) == 0:
            for k in range(5):
              last_candidate.append((i-y-j+k,y+j-k))
          elif n == 5:
            for k in range(5):
              p = (i-y-j+k,y+j-k)
              if p in last_candidate:
                last_candidate = [p]
                break
            else:
              return False
          elif last_candidate[-1] == (i-y-j+5,y+j-5):
            last_candidate.pop()
      else:
        n = 0
  # diagonal (\)
  for i in range(2*N-1):
    n = 0
    y = max(0, i-N+1)
    for j in range(N - abs(N-1-i)):
      if src[y+j][y+j-i+N-1] == c:
        n += 1
        if n >= 5:
          if limit == 0 or n == 10: return False
          if len(last_candidate) == 0:
            for k in range(5):
              last_candidate.append((y+j-i+N-1-k,y+j-k))
          elif n == 5:
            for k in range(5):
              p = (y+j-i+N-1-k,y+j-k)
              if p in last_candidate:
                last_candidate = [p]
                break
            else:
              return False
          elif last_candidate[-1] == (y+j-i+N-1-5,y+j-5):
            last_candidate.pop()
      else:
        n = 0
  return True

def solve():
  os = xs = 0
  for row in src:
    os += row.count('o')
    xs += row.count('x')
  if not 0 <= os-xs <= 1:
    return False

  # last turn is o
  if os > xs:
    return is_ok('x',0) and is_ok('o',1)
  # last turn is x
  else:
    return is_ok('o',0) and is_ok('x',1)

print('YES' if solve() else 'NO')