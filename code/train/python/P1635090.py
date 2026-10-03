# coding:utf-8


def check(S, T, K):
    T_copy = T.copy()
    for i in S:
        if i in T_copy:
            T_copy.remove(i)
    if len(T_copy) > K:
        return False
    else:
        return True


N, K = [int(x) for x in input().split(' ')]
S = list(input())
T = S.copy()
answer = []
for i in range(N - 1):
    cand = sorted(list(set(T)))
    for j in cand:
        T.remove(j)
        if S[i] == j:
            if check(S[i + 1:], T, K):
                answer.append(j)
                break
        else:
            if check(S[i + 1:], T, K - 1):
                answer.append(j)
                K -= 1
                break
        T.append(j)
answer.append(T[0])
print(''.join(answer))
