import sys
mini=-sys.maxsize
A,B=input().split()
for i in range(3):
    for c in "0123456789":
        if i == 0 and c == "0":
            continue
        nA = A[:i] + c + A[i+1:]
        mini = max(mini,eval(nA+"-"+B))
for j in range(3):
    for v in "0123456789":
        if j == 0 and v == "0":
            continue
        nB = B[:j] + v + B[j+1:]
        mini = max(mini,eval(A+"-"+nB))
print(mini)
