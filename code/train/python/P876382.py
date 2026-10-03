S = input()
keta = len(S)

exp_sum = 0
for i in range(1 << keta-1):
    newS = S
    offset = 1
    for j in range(keta):
        if i & (1 << j):
            newS = newS[:j+offset] + "+" + newS[j+offset:]
            offset += 1
    exp_sum += eval(newS)

print(exp_sum)