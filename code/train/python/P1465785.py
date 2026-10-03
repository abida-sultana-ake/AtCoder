K = int(input())


def check(lst):
    for i in range(K):
        maxv = max(lst)
        if maxv <= N - 1:
            return False
        flg = False
        for j in range(N):
            if lst[j] == maxv and not flg:
                lst[j] -= N
                flg = True
            else:
                lst[j] += 1

    for i in range(N):
        if lst[i] >= N:
            return False
    return True



N = 50
mod = K % N
ans = []
for i in range(N):
    if i < mod:
        ans.append(N - i)
    else:
        ans.append(N - mod - 1)

for i in range(N):
    if i < mod:
        ans[i] = ans[i] + K // N + 1
    else:
        ans[i] = ans[i] + K // N
print(N)
print(" ".join(map(str, ans)))
