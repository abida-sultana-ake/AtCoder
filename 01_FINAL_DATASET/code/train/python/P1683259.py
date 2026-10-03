A, B, C = map(int, input().split())

if A == B:
  Ans = C
else:
  if A == C:
    Ans = B
  else:
    Ans = A

print(Ans)