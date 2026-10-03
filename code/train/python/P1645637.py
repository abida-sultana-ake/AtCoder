S = input()

k = 1
pre_s = S[0]
for s in S[1:]:
    if s != pre_s:
        print(pre_s + str(k), end='')
        pre_s = s
        k = 1
    else:
        k += 1

print(S[-1] + str(k))
