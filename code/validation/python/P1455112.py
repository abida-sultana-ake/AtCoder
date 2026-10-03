N, T = list(map(int, input().split()))
A = list(map(int, input().split()))

max_diff = 0
count = 0
minv = A[0]

for i in range(1, len(A)):
    if max_diff < (A[i]- minv):
        max_diff = A[i]- minv
        count = 1
    elif max_diff == (A[i]- minv):
        count += 1
        
    if minv > A[i]:
        minv = A[i]
        
print(count)   