# coding:utf-8


def swap(S, T, K, i, j):
    if i == j or T[i] == T[j]:
        return K

    count = 0
    if S[i] == T[j]:
        count += 1
    if S[j] == T[i]:
        count += 1

    if S[i] == T[i]:
        if S[j] == T[j]:
            if K >= 2:
                tmp = T[i]
                T[i] = T[j]
                T[j] = tmp
                return K - 2
            else:
                return -1
        else:
            if K + count >= 1:
                tmp = T[i]
                T[i] = T[j]
                T[j] = tmp
                return K + count - 1
            else:
                return -1
    else:
        if S[j] == T[j]:
            if K + count >= 1:
                tmp = T[i]
                T[i] = T[j]
                T[j] = tmp
                return K + count - 1
            else:
                return -1
        else:
            tmp = T[i]
            T[i] = T[j]
            T[j] = tmp
            return K + count


N, K = [int(x) for x in input().split(' ')]
S = list(input())
T = S.copy()
for i in range(N):
    sorted_T = sorted(list(set(T[i:])))
    for j in sorted_T:
        count = T[i:].count(j)
        copy_T = T[i:].copy()
        best_K = -1
        best_index = 0
        for k in range(count):
            copy_T2 = T.copy()
            new_K = swap(S, copy_T2, K, i, copy_T.index(j) + k + i)
            if new_K > best_K:
                best_K = new_K
                best_index = copy_T.index(j) + k + i
            copy_T.remove(j)
        if best_K >= 0:
            K = swap(S, T, K, i, best_index)
            break
print(''.join(T))
