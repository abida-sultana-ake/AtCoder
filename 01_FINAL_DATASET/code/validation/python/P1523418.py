N = int(input())
A = list(map(int, input().split()))

A = sorted(A, reverse=True)


pairs = []

flag = True

for i in range(1, len(A)):
    if flag:
        if A[i] == A[i-1]:
            pairs.append(A[i])
            flag = False
    else:
        flag = True
        
if len(pairs) < 2:
    print(0)
else:
    print(pairs[0]*pairs[1])