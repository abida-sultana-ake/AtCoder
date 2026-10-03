def read_int_list():
  return list(map(int, input().split()))
  
r,c,k = read_int_list()
n = int(input())
cand=[]
R=[0]*r
C=[0]*c
for p in range(n):
    ir,jc = read_int_list()
    cand.append((ir-1, jc-1))
    R[ir-1] += 1
    C[jc-1] += 1

cs=[0]*100001
for nc in C:
    cs[nc] += 1

ans = 0

for nr in R:
    left = k - nr
    if left >= 0:
        ans +=cs[left]

for r,c in cand:
    if R[r] + C[c] == k:
        ans -= 1
    if R[r] + C[c] == k+1:
        ans += 1
print(ans)