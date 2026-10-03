n = int(input())
A = {}
for i in range(n):
    s = input()
    if s not in A:
        A[s] = 1
    else:
        A[s] += 1

for i,j in A.items():
    if j == max(i for i in A.values()):
        print(i)
        break