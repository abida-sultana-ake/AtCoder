T = int(input())
N = int(input())
A = list(map(int, input().split()))
M = int(input())
B = list(map(int, input().split()))

result = ""

if M > N:
    result = "no"
else:
    for m in range(M):
        for n in range(N):
            if len(A) == 0:
                result = "no"
                break
            if B[0] - A[0] <= T and A[0] <= B[0]:
                A.pop(0)
                B.pop(0)
                break
            else:
                A.pop(0)

if len(B) == 0:
    result = "yes"
else:
    result = "no"

print(result)
