A=input()
B=input()
s=''
for i in range(len(A)):
  s += A[i]
  if i < len(B):
    s += B[i]
print(s)