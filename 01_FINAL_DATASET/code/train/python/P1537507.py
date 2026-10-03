N,K=map(int,input().split())
S=input()
SS=sorted(S)
T=''
def possible(T, S, t, K):
  for i in range(len(T)):
    if T[i] != S[i]:
      K -= 1
  s = S[len(T):]
  tt = t[:]
  for c in s:
    if c in tt:
      p = tt.index(c)
      tt[p] = '!'
    else:
      K -= 1
  return K >= 0

while len(SS) > 0:
  T += '?'
  for i in range(len(SS)):
    T = T[:-1] + SS[i]
    if possible(T, S, SS[:i] + SS[i+1:], K) :
      SS = SS[:i] + SS[i+1:]
      break
print(T)