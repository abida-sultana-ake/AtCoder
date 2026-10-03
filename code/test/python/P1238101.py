N = int(input())
A = list(map(int, input().split()))
B = [A[0]]

for i in range(1, N):
    B.append(B[i - 1] + A[i])

BB = list(B)

# +, -
ans1 = 0
tmp1 = 0

for i in range(N):
    B[i] += tmp1
    # +
    if i % 2 == 0:
        if B[i] <= 0:
            ans1 += (1 - B[i])
            tmp1 += (1 - B[i])
            B[i] = 1
    # -
    else:
        if B[i] >= 0:
            ans1 += (B[i] + 1)
            tmp1 -= (B[i] + 1)
            B[i] = -1

# -, +
ans2 = 0
tmp2 = 0

for i in range(N):
    BB[i] += tmp2
    # -
    if i % 2 == 0:
        if BB[i] >= 0:
            ans2 += (BB[i] + 1)
            tmp2 -= (BB[i] + 1)
            BB[i] = -1
    # +
    else:
        if BB[i] <= 0:
            ans2 += (1 - BB[i])
            tmp2 += (1 - BB[i])
            BB[i] = 1

print(min(ans1, ans2))
if ans1 < 0 or ans2 < 0:
    raise("hoge")
